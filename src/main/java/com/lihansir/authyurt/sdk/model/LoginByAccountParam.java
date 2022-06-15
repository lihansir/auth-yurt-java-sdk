package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 账户登录参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginByAccountParam {

    /**
     * 账户（用户名/手机号/邮箱）
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 自定义数据
     */
    private LoginCustomData customData;

    public LoginByAccountParam(String account, String password) {
        this.account = account;
        this.password = password;
    }

}
