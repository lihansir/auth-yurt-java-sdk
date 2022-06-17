package com.lihansir.authyurt.sdk.enums;

/**
 * 消息模板类型
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum MessageTemplateType {

    /**
     * 欢迎邮件
     */
    WELCOME("WELCOME"),

    /**
     * 首次创建用户通知
     */
    FIRST_CREATED_USER("FIRST_CREATED_USER"),

    /**
     * 注册验证码
     */
    REGISTER_VERIFY_CODE("REGISTER_VERIFY_CODE"),

    /**
     * 登录验证码
     */
    LOGIN_VERIFY_CODE("LOGIN_VERIFY_CODE"),

    /**
     * MFA 登录验证码
     */
    MFA_VERIFY_CODE("MFA_VERIFY_CODE"),

    /**
     * 首次邮箱登录验证
     */
    FIRST_EMAIL_LOGIN_VERIFY("FIRST_EMAIL_LOGIN_VERIFY"),

    /**
     * 控制台发起验证
     */
    CONSOLE_CONDUCTED_VERIFY("CONSOLE_CONDUCTED_VERIFY"),

    /**
     * 密码到期提醒
     */
    USER_PASSWORD_UPDATE_REMIND("USER_PASSWORD_UPDATE_REMIND"),

    /**
     * 管理员重置密码提醒
     */
    ADMIN_RESET_USER_PASSWORD_NOTIFICATION("ADMIN_RESET_USER_PASSWORD_NOTIFICATION"),

    /**
     * 账户密码修改提醒
     */
    USER_PASSWORD_RESET_NOTIFICATION("USER_PASSWORD_RESET_NOTIFICATION"),

    /**
     * 自助解锁验证码
     */
    SELF_UNLOCKING_VERIFY_CODE("SELF_UNLOCKING_VERIFY_CODE"),

    /**
     * 重置密码验证码
     */
    RESET_PASSWORD_VERIFY_CODE("RESET_PASSWORD_VERIFY_CODE"),

    /**
     * 绑定验证码
     */
    BIND_VERIFY_CODE("BIND_VERIFY_CODE"),

    /**
     * 修改绑定邮箱
     */
    CHANGE_EMAIL("CHANGE_EMAIL"),

    /**
     * 测试邮件
     */
    TEST_EMAIL("TEST_EMAIL");

    private final String type;

    MessageTemplateType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
