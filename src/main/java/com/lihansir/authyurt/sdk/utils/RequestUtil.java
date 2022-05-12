package com.lihansir.authyurt.sdk.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.lihansir.authyurt.sdk.exception.AuthYurtException;

/**
 * 请求工具类
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class RequestUtil {

    /**
     * 获取 OIDC 响应结果
     *
     * @param result 响应结果
     * @return 响应结果对象
     */
    public static JSONObject getOidcResult(String result) {
        JSONObject resultObject = JSONObject.parseObject(result);
        String errorCode = resultObject.getString("error");
        if (StrUtil.isNotBlank(errorCode)) {
            throw new AuthYurtException(errorCode, resultObject.getString("error_description"));
        }
        return resultObject;
    }

    private RequestUtil() {
    }

}