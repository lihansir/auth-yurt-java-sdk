package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 搜索应用可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class SearchApplicationOptions {

    private int currentPage = 1;

    private int pageSize = 10;

    /**
     * 是否是集成应用
     */
    private Boolean integrate;

    /**
     * 是否开启单点登录
     */
    private Boolean ssoEnabled;

}
