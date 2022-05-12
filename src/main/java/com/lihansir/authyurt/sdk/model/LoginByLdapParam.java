package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * LDAP 登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByLdapParam {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public LoginByLdapParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
