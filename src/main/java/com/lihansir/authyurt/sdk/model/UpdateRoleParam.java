package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 修改角色参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class UpdateRoleParam {

    /**
     * 角色 code
     */
    private String code;

    /**
     * 新角色 code（可为空）
     */
    private String newCode;

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

    /**
     * 角色描述（可为空）
     */
    private String description;

    public UpdateRoleParam(String code) {
        this.code = code;
    }

}
