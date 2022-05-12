package com.lihansir.authyurt.sdk.enums;

/**
 * 验证码平台
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum VerificationCodePlatform {

    /**
     * 短信
     */
    PHONE("PHONE"),

    /**
     * 邮箱
     */
    EMAIL("EMAIL");

    private final String type;

    VerificationCodePlatform(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
