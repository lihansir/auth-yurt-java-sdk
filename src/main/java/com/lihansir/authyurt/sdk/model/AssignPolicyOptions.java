package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 授予策略可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignPolicyOptions {

    /**
     * 是否启用（默认启用，可为空）
     */
    private Boolean enabled;

    /**
     * 是否删除该策略其他的目标（默认为 false，可为空）
     */
    private Boolean deleteOthers;

    /**
     * 是否继承，当 targetType 为 ORG 时生效（可为空）
     */
    private Boolean inherit;

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

}
