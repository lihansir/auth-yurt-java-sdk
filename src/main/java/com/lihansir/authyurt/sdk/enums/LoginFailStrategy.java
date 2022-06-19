package com.lihansir.authyurt.sdk.enums;

/**
 * 登录安全策略
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum LoginFailStrategy {

    /**
     * 账号锁定
     */
    BLOCK_ACCOUNT,

    /**
     * 验证码
     */
    CAPTCHA

}
