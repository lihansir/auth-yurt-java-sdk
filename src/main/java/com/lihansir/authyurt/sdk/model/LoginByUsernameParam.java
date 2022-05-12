package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 用户名登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByUsernameParam {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public LoginByUsernameParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
