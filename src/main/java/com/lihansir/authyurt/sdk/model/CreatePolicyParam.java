package com.lihansir.authyurt.sdk.model;

import lombok.Data;

import java.util.List;

/**
 * 创建策略参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreatePolicyParam {

    /**
     * 策略编号
     */
    private String code;

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

    public CreatePolicyParam(String code, List<PolicyStatementParam> statements) {
        this.code = code;
        this.statements = statements;
    }

}
