package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 手机号验证码登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByPhoneCodeParam {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    public LoginByPhoneCodeParam(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

}
