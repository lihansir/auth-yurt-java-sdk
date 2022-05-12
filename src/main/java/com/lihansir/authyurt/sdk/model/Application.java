package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.ClientSecretAuthMethod;
import com.lihansir.authyurt.sdk.enums.IdTokenSignerEnum;
import com.lihansir.authyurt.sdk.enums.ProtocolEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 应用
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    /**
     * 应用 ID
     */
    private String id;

    /**
     * 应用 access secret
     */
    private String secret;

    private String userPoolId;

    private String logo;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 唯一标识符
     */
    private String identifier;

    private String description;

    /**
     * 默认协议类型
     */
    private ProtocolEnum protocol;

    /**
     * 客户端认证方式
     */
    private ClientSecretAuthMethod clientSecretAuthMethod;

    /**
     * 重定向 url 地址
     */
    private List<String> redirectUris;

    /**
     * 登出回调地址
     */
    private List<String> logoutRedirectUris;

    /**
     * id_token 签名算法，暂时支持 HS256 和 RS256
     */
    private IdTokenSignerEnum idTokenSigner;

    private List<String> grantTypes;

    private List<String> responseTypes;

    private List<String> resourceIds;

    private List<String> scopes;

    private List<String> authorities;

    /**
     * 登录 tab
     */
    private List<String> loginTabs;

    /**
     * 默认登录 tab
     */
    private String defaultLoginTab;

    /**
     * 注册 tab
     */
    private List<String> registerTabs;

    private String defaultRegisterTab;

    private ApplicationPasswordTabConfig passwordTabConfig;

    private ApplicationVerifyCodeTabConfig verifyCodeTabConfig;

    private List<String> mfa;

    /**
     * code 换取 token 有效时间
     */
    private Long codeToTokenValiditySeconds;

    private Long accessTokenValiditySeconds;

    private Long refreshTokenValiditySeconds;

    private Long cookieValiditySeconds;

    private Long idTokenValiditySeconds;

    /**
     * 是否可用
     */
    private Boolean available;

    /**
     * 自动批准(不显示确认页面)
     */
    private Boolean autoApprove;

    private String jwks;

    /**
     * saml 配置
     */
    private SamlIdpConfig samlIdpConfig;

    /**
     * cas 配置
     */
    private CasIdpConfig casIdpConfig;

    /**
     * oauth 配置
     */
    private OauthIdpConfig oauthIdpConfig;

    /**
     * 应用授权 配置
     */
    private ApplicationPermissionStrategyConfig permissionStrategy;

    /**
     * 是否开启单点登录
     */
    private Boolean ssoEnabled;

    private String css;

    /**
     * 隐藏企业身份源登录
     */
    private Boolean disabledEnterpriseConnectionLogin;

    /**
     * 隐藏社会化登录按钮
     */
    private Boolean disabledSocialConnectionLogin;

    /**
     * 隐藏忘记密码按钮
     */
    private Boolean disabledForgetPasswordButton;

    /**
     * 是否为用户池默认应用
     */
    private Boolean defaultApplication;

    /**
     * 是否为集成应用
     */
    private Boolean integrate;

    /**
     * 集成应用模板
     */
    private String template;

    /**
     * 发起登录 URL
     * 在应用详情点击「体验登录」或在应用面板点击该应用图标时，会跳转到此 URL，默认为登录页
     */
    private String initLoginUrl;

}
