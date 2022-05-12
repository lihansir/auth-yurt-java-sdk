package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码强度校验结果
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckPasswordStrengthResult {

    /**
     * 是否通过校验
     */
    private boolean valid;

    /**
     * 提示信息
     */
    private String message;

}
