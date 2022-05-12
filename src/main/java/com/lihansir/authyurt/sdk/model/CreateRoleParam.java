package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 创建角色参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreateRoleParam {

    /**
     * 角色 code
     */
    private String code;

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

    /**
     * 角色描述（可为空）
     */
    private String description;

    public CreateRoleParam(String code) {
        this.code = code;
    }

}
