package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 更新分组参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class UpdateGroupParam {

    /**
     * 分组 code
     */
    private String code;

    /**
     * 新分组 code
     */
    private String newCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 外部分组 ID
     */
    private String externalId;

    public UpdateGroupParam(String code) {
        this.code = code;
    }

}
