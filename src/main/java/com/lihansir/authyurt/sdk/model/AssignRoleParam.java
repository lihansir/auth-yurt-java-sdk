package com.lihansir.authyurt.sdk.model;

import lombok.Data;

import java.util.List;

/**
 * 角色授权参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class AssignRoleParam {

    /**
     * 角色 code
     */
    private String roleCode;

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

    /**
     * 用户 ID 数组（可为空）
     */
    private List<String> userIds;

    /**
     * 机构节点 ID （唯一 ID）数组（可为空）
     */
    private List<String> orgNodeIds;

    /**
     * 分组 code 数组（可为空）
     */
    private List<String> groupCodes;

    public AssignRoleParam(String roleCode) {
        this.roleCode = roleCode;
    }

}
