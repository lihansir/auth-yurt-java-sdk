package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 修改机构参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class UpdateOrgParam {

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
     * 父级机构 ID
     */
    private String parentOrgId;

}
