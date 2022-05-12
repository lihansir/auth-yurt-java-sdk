package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义密码强度
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomPasswordStrength {

    /**
     * 正则表达式
     */
    private String regex;

    /**
     * 密码错误提示信息
     */
    private String message;

}
