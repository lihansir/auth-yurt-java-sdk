package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取策略列表参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyListParam {

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

    /**
     * 是否为系统默认策略（可为空）
     */
    private Boolean systemDefault;

}
