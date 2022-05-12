package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 邮箱验证码登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByEmailCodeParam {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String code;

    public LoginByEmailCodeParam(String email, String code) {
        this.email = email;
        this.code = code;
    }

}
