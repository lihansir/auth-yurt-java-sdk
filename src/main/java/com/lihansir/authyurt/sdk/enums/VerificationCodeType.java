package com.lihansir.authyurt.sdk.enums;

/**
 * 验证码类型
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum VerificationCodeType {

    /**
     * 重置密码
     */
    RESET_PASSWORD("RESET_PASSWORD"),

    /**
     * 注册
     */
    REGISTER("REGISTER"),

    /**
     * 登录
     */
    LOGIN("LOGIN"),

    /**
     * 绑定
     */
    BIND("BIND"),

    /**
     * MFA 验证
     */
    MFA("MFA");

    private final String type;

    VerificationCodeType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
