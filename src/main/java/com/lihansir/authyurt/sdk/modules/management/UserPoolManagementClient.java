package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.CheckPasswordStrengthResult;
import com.lihansir.authyurt.sdk.model.Env;
import com.lihansir.authyurt.sdk.model.UpdateUserPoolParam;
import com.lihansir.authyurt.sdk.model.UserPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户池管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class UserPoolManagementClient {

    private final ManagementClient managementClient;

    /**
     * 查询用户池配置
     */
    public UserPool detail() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/userPool/getUserPoolInfo");
        return this.managementClient.get(url, UserPool.class);
    }

    /**
     * 更新用户池配置
     */
    public UserPool update(UpdateUserPoolParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/userPool/updateUserPool");
        return this.managementClient.put(url, param, UserPool.class);
    }

    /**
     * 获取环境变量列表
     */
    public List<Env> listEnv() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/env/list");
        return this.managementClient.get(url, new TypeReference<List<Env>>() {
        });
    }

    /**
     * 添加环境变量
     */
    public Env addEnv(String key, String value) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/env");
        Map<String, Object> data = new HashMap<>(2);
        data.put("key", key);
        data.put("value", value);
        return this.managementClient.post(url, data, Env.class);
    }

    /**
     * 获取单个环境变量
     */
    public Env getEnv(String key) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/env/" + key);
        return this.managementClient.get(url, Env.class);
    }

    /**
     * 删除环境变量
     */
    public void removeEnv(String key) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/env/" + key);
        this.managementClient.delete(url);
    }

    /**
     * 刷新用户池密钥
     */
    public void refreshSecret() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/userPool/refreshSecret");
        this.managementClient.put(url);
    }

    /**
     * 检查密码强度
     *
     * @param password 密码
     * @return 检查结果
     */
    public CheckPasswordStrengthResult checkPasswordStrength(String password) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/password/check");
        Map<String, Object> data = new HashMap<>(1);
        data.put("password", password);
        return this.managementClient.post(url, data, CheckPasswordStrengthResult.class);
    }

    public UserPoolManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
