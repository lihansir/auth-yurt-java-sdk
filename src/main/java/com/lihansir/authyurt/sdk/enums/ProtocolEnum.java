package com.lihansir.authyurt.sdk.enums;

/**
 * 应用协议类型枚举
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum ProtocolEnum {

    /**
     * oidc
     */
    OIDC("oidc"),

    /**
     * saml
     */
    SAML("saml"),

    /**
     * cas
     */
    CAS("cas"),

    /**
     * oauth
     */
    OAUTH("oauth");

    private final String value;

    ProtocolEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
