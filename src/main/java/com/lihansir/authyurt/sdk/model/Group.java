package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分组
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    /**
     * 分组 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 分组 code
     */
    private String code;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组描述
     */
    private String description;

    /**
     * 外部分组 ID
     */
    private String externalId;

    public Long gmtCreate;

    public Long gmtModified;

}
