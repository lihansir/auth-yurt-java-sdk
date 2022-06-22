package com.lihansir.authyurt.sdk.modules;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.PemUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.exception.AuthYurtException;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Map;

/**
 * 基础客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public abstract class BaseClient {

    /**
     * 服务地址，可选参数
     */
    private String host = "https://core.authyurt.com";

    /**
     * 公钥
     */
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDzKvnPgC/dPfy\n" +
            "DEP3nxCxMptv5NF8LAaHx5Ao/wO3jJ3KnpFL7fuZQb/51Atfx/g9\n" +
            "j1imx6Ty74aqeHoWjZKEp8CX6VI0mhIQr8YACXy9xDfTAcqWeJU5\n" +
            "aq1poTIG5xA9sr62JeHcoLLuUnWbbcdeauFdO5XPHAePr27tc69X\n" +
            "NQIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    private String userPoolId;

    /**
     * 每次发出请求时会附加在请求头的 token
     * <p>
     * 访问某些需要权限的接口则必须设置此变量
     */
    private String token;

    /**
     * token 过期时间
     */
    private Long accessTokenExpiresAt;

    /**
     * 应用 Id
     */
    private String applicationId;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 连接超时时间（毫秒）
     */
    private int connectTimeOut = 10000;

    /**
     * 读取超时时间（毫秒）
     */
    private int readTimeOut = 10000;

    /**
     * SDK 版本
     */
    private String sdkVersion = "java:1.0.0";

    /**
     * 请求来源
     */
    private String requestFrom = "sdk";

    /**
     * 语言
     */
    private String lang = "zh-CN";

    /**
     * 密码加密
     *
     * @param password 原始密码
     * @return 加密后的密码
     */
    public String encrypt(String password) {
        if (StrUtil.isBlank(password)) {
            return StrUtil.EMPTY;
        }
        PublicKey publicKey = PemUtil.readPemPublicKey(new ByteArrayInputStream(this.publicKey.getBytes(StandardCharsets.UTF_8)));
        RSA rsa = SecureUtil.rsa(null, publicKey.getEncoded());
        return rsa.encryptBase64(password, KeyType.PublicKey);
    }

    protected <T> T baseGet(String path, Map<String, Object> queryMapStr, Class<T> dataClass) {
        return formatResponse(baseGet(path, queryMapStr), dataClass);
    }

    protected <T> T baseGet(String path, Map<String, Object> queryMapStr, TypeReference<T> typeReference) {
        return formatResponse(baseGet(path, queryMapStr), typeReference);
    }

    protected String baseGet(String path, Map<String, Object> queryMapStr) {
        HttpRequest request = HttpUtil.createGet(this.host + path).form(queryMapStr);
        fullRequestInfo(request);
        return request.execute().body();
    }

    protected <T> T basePostForm(String path, Map<String, Object> formMapStr, Class<T> dataClass) {
        return formatResponse(basePostForm(path, formMapStr), dataClass);
    }

    protected <T> T basePostForm(String path, Map<String, Object> formMapStr, TypeReference<T> typeReference) {
        return formatResponse(basePostForm(path, formMapStr), typeReference);
    }

    protected String basePostForm(String path, Map<String, Object> formMapStr) {
        HttpRequest request = HttpUtil.createPost(this.host + path).form(formMapStr);
        fullRequestInfo(request);
        return request.execute().body();
    }

    protected <T> T basePost(String path, Object body, Class<T> dataClass) {
        return formatResponse(basePost(path, body), dataClass);
    }

    protected <T> T basePost(String path, Object body, TypeReference<T> typeReference) {
        return formatResponse(basePost(path, body), typeReference);
    }

    protected String basePost(String path, Object body) {
        HttpRequest request = HttpUtil.createPost(this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        return request.execute().body();
    }

    protected String basePut(String path) {
        HttpRequest request = HttpUtil.createRequest(Method.PUT, this.host + path);
        fullRequestInfo(request);
        return formatResponse(request.execute().body(), String.class);
    }

    protected <T> T basePut(String path, Object body, Class<T> dataClass) {
        HttpRequest request = HttpUtil.createRequest(Method.PUT, this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        return formatResponse(request.execute().body(), dataClass);
    }

    protected <T> T basePut(String path, Object body, TypeReference<T> typeReference) {
        HttpRequest request = HttpUtil.createRequest(Method.PUT, this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        return formatResponse(request.execute().body(), typeReference);
    }

    protected <T> T basePatch(String path, Object body, Class<T> dataClass) {
        HttpRequest request = HttpUtil.createRequest(Method.PATCH, this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        return formatResponse(request.execute().body(), dataClass);
    }

    protected <T> T basePatch(String path, Object body, TypeReference<T> typeReference) {
        HttpRequest request = HttpUtil.createRequest(Method.PATCH, this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        return formatResponse(request.execute().body(), typeReference);
    }

    protected void baseDelete(String path, Object body) {
        HttpRequest request = HttpUtil.createRequest(Method.DELETE, this.host + path).body(JSONObject.toJSONString(body));
        fullRequestInfo(request);
        formatResponse(request.execute().body(), String.class);
    }

    protected void baseDeleteWithParam(String path, Map<String, Object> param) {
        HttpRequest request = HttpUtil.createRequest(Method.DELETE, this.host + path).form(param);
        fullRequestInfo(request);
        formatResponse(request.execute().body(), String.class);
    }

    private <T> T formatResponse(String responseContent, Class<T> dataClass) {
        return formatResponse(responseContent).getObject("data", dataClass);
    }

    private <T> T formatResponse(String responseContent, TypeReference<T> typeReference) {
        return formatResponse(responseContent).getObject("data", typeReference);
    }

    private JSONObject formatResponse(String responseContent) {
        if (StrUtil.isBlank(responseContent)) {
            throw new AuthYurtException("http response error");
        }
        JSONObject resultObject = JSONObject.parseObject(responseContent);
        boolean success = resultObject.getBooleanValue("success");
        if (!success) {
            throw new AuthYurtException(resultObject.getString("errorCode"), resultObject.getString("errorMessage"));
        }
        return resultObject;
    }

    private void fullRequestInfo(HttpRequest httpRequest) {
        httpRequest.header(CommonConstant.CLIENT_ID_HEADER_NAME, this.applicationId);
        httpRequest.header(CommonConstant.CLIENT_SECRET_HEADER_NAME, this.secret);
        if (StrUtil.isNotBlank(this.token)) {
            httpRequest.header("Authorization", "Bearer " + this.token);
        }
        httpRequest.header("_auth_yurt_sdk_version", this.sdkVersion);
        httpRequest.header(CommonConstant.USER_POOL_ID_HEADER_NAME, this.userPoolId);
        httpRequest.header("_auth_yurt_request_from", this.requestFrom);
        httpRequest.header("_auth_yurt_lang", this.lang);
        httpRequest.setConnectionTimeout(this.connectTimeOut);
        httpRequest.setReadTimeout(this.readTimeOut);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUserPoolId() {
        return userPoolId;
    }

    public void setUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public void setAccessTokenExpiresAt(Long accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(String requestFrom) {
        this.requestFrom = requestFrom;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
