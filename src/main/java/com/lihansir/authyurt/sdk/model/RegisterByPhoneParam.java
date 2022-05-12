package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 手机号注册参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class RegisterByPhoneParam {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 密码
     */
    private String password;

    public RegisterByPhoneParam(String phone, String code, String password) {
        this.phone = phone;
        this.code = code;
        this.password = password;
    }

}
