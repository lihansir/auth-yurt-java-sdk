package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 邮箱注册参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class RegisterByEmailParam {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    public RegisterByEmailParam(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
