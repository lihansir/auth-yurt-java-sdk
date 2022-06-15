package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 邮箱登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByEmailParam {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 自定义数据
     */
    private LoginCustomData customData;

    public LoginByEmailParam(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
