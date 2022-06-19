package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 机构
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Org {

    /**
     * 唯一 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 机构 ID
     */
    private String orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构描述
     */
    private String description;

    /**
     * 机构别名
     */
    private String orgAlias;

    /**
     * 机构编码
     */
    private String orgNum;

    /**
     * 父级 ID
     */
    private String parentOrgId;

    /**
     * 三方平台 ID（即机构所归属的三方平台 ID）
     */
    private String thirdPartyPlatformId;

    public Long gmtCreate;

    public Long gmtModified;

}
