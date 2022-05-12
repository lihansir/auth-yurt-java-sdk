package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class ApplicationManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建应用
     */
    public Application create(CreateApplicationParam param) {
        return create(param, null);
    }

    /**
     * 创建应用
     */
    public Application create(CreateApplicationParam param, CreateApplicationOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application");
        Map<String, Object> data = new HashMap<>(3);
        data.put("name", param.getName());
        data.put("identifier", param.getIdentifier());
        if (options != null) {
            data.put("logo", options.getLogo());
        }
        return this.managementClient.post(url, data, Application.class);
    }

    /**
     * 修改应用
     *
     * @param applicationId 应用 ID
     * @param updateParam   修改项
     */
    public Application update(String applicationId, UpdateApplicationParam updateParam) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application");
        Application application = BeanUtil.copyProperties(updateParam, Application.class);
        application.setId(applicationId);
        return this.managementClient.put(url, application, Application.class);
    }

    /**
     * 获取应用详情
     */
    public Application detail(String applicationId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application/" + applicationId);
        return this.managementClient.get(url, Application.class);
    }

    /**
     * 获取用户池默认应用信息
     */
    public Application defaultApplication() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application/default");
        return this.managementClient.get(url, Application.class);
    }

    /**
     * 删除应用
     */
    public void delete(String applicationId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application/" + applicationId);
        this.managementClient.delete(url);
    }

    /**
     * 获取全部应用列表
     */
    public List<Application> all() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application/getByUserPoolId");
        return this.managementClient.get(url, new TypeReference<List<Application>>() {
        });
    }

    /**
     * 搜索应用
     */
    public PageResult<Application> search(String query) {
        return search(query, null);
    }

    /**
     * 搜索应用
     */
    public PageResult<Application> search(String query, SearchApplicationOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/application/search");
        Map<String, Object> param = new HashMap<>(5);
        param.put("query", query);
        if (options != null) {
            param.put("currentPage", options.getCurrentPage());
            param.put("pageSize", options.getPageSize());
            param.put("integrate", options.getIntegrate());
            param.put("ssoEnabled", options.getSsoEnabled());
        }
        return this.managementClient.get(url, param, new TypeReference<PageResult<Application>>() {
        });
    }

    /**
     * 刷新应用密钥
     *
     * @param applicationId 应用 ID
     */
    public void refreshSecret(String applicationId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application/refreshSecret?applicationId=" + applicationId);
        this.managementClient.put(url);
    }

    /**
     * 查看当前登录应用的用户
     *
     * @param applicationId 应用 ID
     */
    public PageResult<User> activeUsers(String applicationId) {
        return activeUsers(applicationId, 1, 10);
    }

    /**
     * 查看当前登录应用的用户
     *
     * @param applicationId 应用 ID
     */
    public PageResult<User> activeUsers(String applicationId, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}{}/activeUsers", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/login-status/", applicationId);
        Map<String, Object> param = new HashMap<>(2);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<User>>() {
        });
    }

    /**
     * 强制用户下线
     *
     * @param applicationId 应用 ID
     * @param userIds       用户 ID 数组
     */
    public void kickActiveUsers(String applicationId, List<String> userIds) {
        String url = StrUtil.format("{}{}{}/users/kickActive", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/login-status/", applicationId);
        Map<String, Object> data = new HashMap<>(1);
        data.put("userIds", userIds);
        this.managementClient.post(url, data);
    }

    public ApplicationManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
