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
 * 用户管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class UserManagementClient {

    private final ManagementClient managementClient;

    /**
     * 查看用户详情
     * @param id 用户 ID
     * @return 用户详情
     */
    public User detail(String id) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user/" + id);
        return this.managementClient.get(url, User.class);
    }

    /**
     * 创建用户
     * @param createUserParam 用户信息
     * @return 用户详情
     */
    public User create(CreateUserParam createUserParam) {
        return create(createUserParam, null);
    }

    /**
     * 创建用户
     * @param createUserParam 用户信息
     * @param options 可选项
     * @return 用户详情
     */
    public User create(CreateUserParam createUserParam, CreateUserOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user");
        String password = createUserParam.getPassword();
        if (StrUtil.isNotBlank(password)) {
            createUserParam.setPassword(this.managementClient.encrypt(password));
        }
        Map<String, Object> data = new HashMap<>(4);
        data.put("userInfo", createUserParam);
        if (options != null) {
            data.put("keepPassword", options.getKeepPassword());
            data.put("sendFirstLoginInfo", options.getSendFirstLoginInfo());
            data.put("applicationId", options.getApplicationId());
        }
        return this.managementClient.post(url, data, User.class);
    }

    /**
     * 更新用户信息
     * @param userId 用户 ID
     * @param updateParam 更新内容
     * @return 用户详情
     */
    public User update(String userId, UpdateUserParam updateParam) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user");
        String password = updateParam.getPassword();
        if (StrUtil.isNotBlank(password)) {
            updateParam.setPassword(this.managementClient.encrypt(password));
        }
        User user = BeanUtil.copyProperties(updateParam, User.class);
        user.setId(userId);
        return this.managementClient.put(url, user, User.class);
    }

    /**
     * 删除用户
     * @param id 用户 ID
     */
    public void delete(String id) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user/" + id);
        this.managementClient.delete(url);
    }

    /**
     * 删除多个用户
     * @param userIds 用户 ID 数组
     */
    public void deleteMany(List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user/deleteUserByIdList");
        Map<String, Object> data = new HashMap<>(1);
        data.put("identifiers", userIds);
        this.managementClient.post(url, data);
    }

    /**
     * 搜索用户
     * @param query 查询内容（模糊搜索用户 ID / 用户名 / 手机号 / 邮箱 / 姓名 / 昵称）
     * @param currentPage 当前页数
     * @param pageSize 每页条数
     * @return 结果
     */
    public PageResult<User> search(String query, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/user/searchUser");
        Map<String, Object> param = new HashMap<>(3);
        param.put("query", query);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<User>>() {
        });
    }

    /**
     * 强制用户下线
     * @param userIds 用户 ID 数组
     */
    public void kick(List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/login-status/users/kick");
        Map<String, Object> data = new HashMap<>(1);
        data.put("userIds", userIds);
        this.managementClient.post(url, data);
    }

    public UserManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
