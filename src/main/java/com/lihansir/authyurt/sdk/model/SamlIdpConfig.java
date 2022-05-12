package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Saml 配置
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SamlIdpConfig {

    private boolean enabled;

    private String acs;

    private String authnContextClassRef;

    private String digestAlgorithm;

    private Long lifetimeInSeconds;

    private String nameIdentifierFormat;

    private String samlResponseSigningCert;

    private String samlResponseSigningKey;

    private String signatureAlgorithm;

    /**
     * SAML Request 验签证书，你可以从 SP 获得此证书内容。填写此字段后，会认为 SAML Request 经过签名，并检查签名是否合法。如果 SP 未对请求进行签名，IDP 会拒绝 SAML Request 导致认证失败。
     */
    private String samlRequestSigningCert;

    /**
     * 是否对 SAML Response 签名
     */
    private boolean signResponse;

    private List<SamlIdpCustomAttribute> customAttributes;

    /**
     * 属性映射字典，AuthYurt 用户信息中的字段映射到 SAML 身份断言中的映射字典， key 代表用户在 AuthYurt 中的信息字段， value 代表 SAML 身份断言中的属性名。
     */
    private Map<String, String> mappings;

    /**
     * SAML Response 中的 destination
     * 默认为 SAML Request 中的 AssertionConsumerServiceURL，如果不存在，就为配置的默认 ACS 地址。
     */
    private String destination;

    /**
     * SAML Response 中的 recipient
     * 默认为 SAML Request 中的 AssertionConsumerServiceURL，如果不存在，就为配置的默认 ACS 地址。
     */
    private String recipient;

    /**
     * SAML Response 中的 audience
     * 默认为 SAML Request 中的 AssertionConsumerServiceURL，如果不存在，就为配置的默认 ACS 地址。
     */
    private String audience;

    /**
     * 邮件域替换，SAML 断言中的身份标识中的邮箱域名会被替换为这里填写的内容，一些 SP 要求身份断言中的邮件域必须为特定的内容。如果填写此字段，必须禁止用户池注册，否则存在账号冒用风险。
     */
    private String emailDomainSubstitution;

    /**
     * 用户唯一键属性名称
     */
    private String userIdentifierName;

}
