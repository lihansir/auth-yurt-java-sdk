package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 手机号密码登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByPhonePasswordParam {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 自定义数据
     */
    private LoginCustomData customData;

    public LoginByPhonePasswordParam(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

}
