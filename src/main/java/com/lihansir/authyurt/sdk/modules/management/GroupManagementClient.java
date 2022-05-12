package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户分组管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class GroupManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建分组
     */
    public Group create(CreateGroupParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/create");
        return this.managementClient.post(url, param, Group.class);
    }

    /**
     * 修改分组
     */
    public Group update(UpdateGroupParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/update");
        return this.managementClient.put(url, param, Group.class);
    }

    /**
     * 分组详情
     */
    public Group detail(String code) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/getGroupByCode/" + code);
        return this.managementClient.get(url, Group.class);
    }

    /**
     * 分页获取分组列表
     */
    public PageResult<Group> list(int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/findGroupByPage");
        Map<String, Object> param = new HashMap<>(2);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<Group>>() {
        });
    }

    /**
     * 获取全部分组列表
     */
    public List<Group> all() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/findAllGroups");
        return this.managementClient.get(url, new TypeReference<List<Group>>() {
        });
    }

    /**
     * 删除分组
     */
    public void delete(String code) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group/deleteGroupByCode/" + code);
        this.managementClient.delete(url);
    }

    /**
     * 添加用户到分组
     *
     * @param code    分组 code
     * @param userIds 用户 ID 数组
     */
    public void addMember(String code, List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group-user");
        Map<String, Object> data = new HashMap<>(2);
        data.put("groupCode", code);
        data.put("userIds", userIds);
        this.managementClient.post(url, data);
    }

    /**
     * 从分组中移除用户
     *
     * @param code    分组 code
     * @param userIds 用户 ID 数组
     */
    public void removeMember(String code, List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group-user");
        Map<String, Object> data = new HashMap<>(2);
        data.put("groupCode", code);
        data.put("userIds", userIds);
        this.managementClient.delete(url, data);
    }

    /**
     * 获取分组下的用户信息列表
     *
     * @param code 分组 code
     */
    public PageResult<User> listUser(String code, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group-user/findUserListByGroupCode");
        Map<String, Object> param = new HashMap<>(3);
        param.put("code", code);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<User>>() {
        });
    }

    /**
     * 获取用户所属分组列表
     *
     * @param userId 用户 ID
     */
    public PageResult<Group> listGroup(String userId, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/group-user/findGroupListByUserId");
        Map<String, Object> param = new HashMap<>(3);
        param.put("userId", userId);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<Group>>() {
        });
    }

    public GroupManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
