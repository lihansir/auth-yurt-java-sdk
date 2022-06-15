package com.lihansir.authyurt.sdk.modules.authentication;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.constant.EndpointPathConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.enums.*;
import com.lihansir.authyurt.sdk.modules.BaseClient;
import com.lihansir.authyurt.sdk.utils.RequestUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class AuthenticationClient extends BaseClient {

    /**
     * 账户密码登录
     */
    public AuthenticationResult loginByAccount(LoginByAccountParam param) {
        param.setPassword(encrypt(param.getPassword()));
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/authentication/loginByAccount", param, AuthenticationResult.class);
    }

    /**
     * ldap 登录
     */
    public AuthenticationResult loginByLdap(LoginByLdapParam param) {
        param.setPassword(encrypt(param.getPassword()));
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/authentication/loginByLdap", param, AuthenticationResult.class);
    }

    /**
     * 邮箱验证码登录
     */
    public AuthenticationResult loginByEmailCode(LoginByEmailCodeParam param) {
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/authentication/loginByEmailCode", param, AuthenticationResult.class);
    }

    /**
     * 手机号验证码登录
     */
    public AuthenticationResult loginByPhoneCode(LoginByPhoneCodeParam param) {
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/authentication/loginByPhone", param, AuthenticationResult.class);
    }

    /**
     * 用户名密码注册
     */
    public User registerByUsername(RegisterByUsernameParam param) {
        param.setPassword(encrypt(param.getPassword()));
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/register/registerByUsername", param, User.class);
    }

    /**
     * 邮箱密码注册
     */
    public User registerByEmail(RegisterByEmailParam param) {
        param.setPassword(encrypt(param.getPassword()));
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/register/registerByEmail", param, User.class);
    }

    /**
     * 手机号注册
     */
    public User registerByPhone(RegisterByPhoneParam param) {
        param.setPassword(encrypt(param.getPassword()));
        return basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/register/registerByPhone", param, User.class);
    }

    /**
     * 发送验证码
     *
     * @param target   发送目标
     * @param platform 发送平台
     * @param type     验证码类型
     */
    public void sendCaptcha(String target, VerificationCodePlatform platform, VerificationCodeType type) {
        Map<String, Object> param = new HashMap<>(3);
        param.put("identifier", target);
        param.put("platform", platform.getType());
        param.put("type", type.getType());
        basePost(CommonConstant.IDAAS_CONTEXT_PATH + "/api/third-party-information/send", param, String.class);
    }

    /**
     * 生成 OIDC 授权链接
     */
    public String generateOidcAuthorizationUrl(String scope, ResponseType responseType, String redirectUri, String state, String nonce) {
        UrlBuilder urlBuilder = UrlBuilder.of(StrUtil.format("{}{}{}", getHost(), CommonConstant.IDAAS_CONTEXT_PATH,
                EndpointPathConstant.LOGIN));
        urlBuilder.addQuery("client_id", getApplicationId());
        urlBuilder.addQuery("protocol", ProtocolEnum.OIDC.getValue());
        urlBuilder.addQuery("scope", scope);
        urlBuilder.addQuery("response_type", responseType.getType());
        urlBuilder.addQuery("redirect_uri", redirectUri);
        urlBuilder.addQuery("state", state);
        urlBuilder.addQuery("nonce", nonce);
        return urlBuilder.build();
    }

    /**
     * 授权码换取 token
     */
    public AccessToken oidcCodeToToken(String code, String redirectUri) {
        Assert.notBlank(code);
        Assert.notBlank(redirectUri);
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, EndpointPathConstant.TOKEN);
        Map<String, Object> data = new HashMap<>(3);
        data.put("code", code);
        data.put("grant_type", GrantType.AUTHORIZATION_CODE.getType());
        data.put("redirect_uri", redirectUri);
        String result = basePostForm(url, data);
        JSONObject oidcResult = RequestUtil.getOidcResult(result);
        return BeanUtil.fillBeanWithMap(oidcResult, new AccessToken(), true, true);
    }

    /**
     * 刷新 token
     */
    public AccessToken oidcRefreshToken(String refreshToken, String scope) {
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, EndpointPathConstant.TOKEN);
        Map<String, Object> data = new HashMap<>(3);
        data.put("grant_type", GrantType.REFRESH_TOKEN.getType());
        data.put("refresh_token", refreshToken);
        data.put("scope", scope);
        String result = basePostForm(url, data);
        JSONObject oidcResult = RequestUtil.getOidcResult(result);
        return BeanUtil.fillBeanWithMap(oidcResult, new AccessToken(), true, true);
    }

    /**
     * token 自省
     */
    public boolean oidcIntrospectionToken(String token) {
        Assert.notBlank(token);
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, EndpointPathConstant.INTROSPECTION_TOKEN);
        Map<String, Object> data = new HashMap<>(1);
        data.put("access_token", token);
        String result = basePostForm(url, data);
        JSONObject oidcResult = RequestUtil.getOidcResult(result);
        return oidcResult.getBoolean("active");
    }

    /**
     * 撤销 token
     */
    public void oidcRevokeToken(String token) {
        Assert.notBlank(token);
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, EndpointPathConstant.REVOKE_TOKEN);
        Map<String, Object> data = new HashMap<>(1);
        data.put("access_token", token);
        basePostForm(url, data);
    }

    /**
     * token 获取用户信息
     */
    public User oidcUserInfo(String token) {
        Assert.notBlank(token);
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, EndpointPathConstant.USER_INFO);
        Map<String, Object> data = new HashMap<>(1);
        data.put("access_token", token);
        String result = basePostForm(url, data);
        JSONObject oidcResult = RequestUtil.getOidcResult(result);
        return BeanUtil.mapToBean(oidcResult, User.class, true, null);
    }

}