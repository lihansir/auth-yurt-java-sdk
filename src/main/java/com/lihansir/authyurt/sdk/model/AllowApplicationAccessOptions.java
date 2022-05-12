package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 允许应用访问权限可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllowApplicationAccessOptions {

    /**
     * 目标权限组 code（TargetType 为 ROLE 时生效）
     */
    private String targetNamespaceCode;

    /**
     * 是否继承（TargetType 为 ORG 时生效）
     */
    private Boolean inherit;

}
