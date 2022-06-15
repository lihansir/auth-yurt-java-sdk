package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 登录自定义数据
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class LoginCustomData {

    /**
     * 验证码 key
     */
    private String captchaKey;

    /**
     * 验证码
     */
    private String captcha;

}
