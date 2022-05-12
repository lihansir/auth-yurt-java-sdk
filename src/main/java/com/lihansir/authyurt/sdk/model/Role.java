package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    /**
     * 用户 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 角色 code
     */
    private String code;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 权限组 ID
     */
    private String namespaceId;

    /**
     * 是否为系统角色
     */
    private Boolean system;

    public Long gmtCreate;

    public Long gmtModified;

}
