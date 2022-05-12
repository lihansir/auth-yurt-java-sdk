package com.lihansir.authyurt.sdk.model;

import lombok.Data;

import java.util.List;

/**
 * 修改策略参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class UpdatePolicyParam {

    /**
     * 新策略编号（可为空）
     */
    private String newCode;

    /**
     * 策略声明
     */
    private List<PolicyStatementParam> statements;

    /**
     * 策略描述（可为空）
     */
    private String description;

    /**
     * 权限组编号（可为空）
     */
    private String namespaceCode;

    public UpdatePolicyParam(List<PolicyStatementParam> statements) {
        this.statements = statements;
    }

}
