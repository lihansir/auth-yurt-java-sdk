package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 应用验证码 tab 配置
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationVerifyCodeTabConfig {

    private List<String> enabledLoginMethods;

}
