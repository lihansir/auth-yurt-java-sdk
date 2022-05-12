package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class RoleManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建角色
     */
    public Role create(CreateRoleParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/create");
        return this.managementClient.post(url, param, Role.class);
    }

    /**
     * 修改角色
     */
    public Role update(UpdateRoleParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/update");
        return this.managementClient.put(url, param, Role.class);
    }

    /**
     * 查看默认权限组角色列表
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @return 角色列表
     */
    public PageResult<Role> list(int currentPage, int pageSize) {
        return list(null, currentPage, pageSize);
    }

    /**
     * 查看权限组角色列表
     *
     * @param namespaceCode 权限组编号
     * @param currentPage   当前页
     * @param pageSize      每页条数
     * @return 角色列表
     */
    public PageResult<Role> list(String namespaceCode, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/findByPage");
        Map<String, Object> param = new HashMap<>(3);
        param.put("namespaceCode", namespaceCode);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<Role>>() {
        });
    }

    /**
     * 获取角色详情
     */
    public Role detail(String code) {
        return detail(code, null);
    }

    /**
     * 获取角色详情
     */
    public Role detail(String code, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/detail");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("namespaceCode", namespaceCode);
        return this.managementClient.get(url, param, Role.class);
    }

    /**
     * 删除角色
     */
    public void delete(String code) {
        delete(code, null);
    }

    /**
     * 删除角色
     */
    public void delete(String code, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("namespaceCode", namespaceCode);
        this.managementClient.deleteWithParam(url, param);
    }

    /**
     * 授权（用户、机构、分组）
     */
    public void assign(AssignRoleParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/assign");
        this.managementClient.post(url, param);
    }

    /**
     * 撤销授权（用户、机构、分组）
     */
    public void revoke(RevokeRoleParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/revoke");
        this.managementClient.post(url, param);
    }

    /**
     * 查找角色下的用户
     *
     * @param code 角色 code
     */
    public PageResult<User> roleWithUsers(String code, int currentPage, int pageSize) {
        return roleWithUsers(code, null, currentPage, pageSize);
    }

    /**
     * 查找角色下的用户
     *
     * @param code          角色 code
     * @param namespaceCode 权限组 code
     */
    public PageResult<User> roleWithUsers(String code, String namespaceCode, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/roleWithUsers");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("namespaceCode", namespaceCode);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<User>>() {
        });
    }

    /**
     * 查找角色下的机构
     *
     * @param code 角色 code
     */
    public PageResult<Org> roleWithOrgs(String code, int currentPage, int pageSize) {
        return roleWithOrgs(code, null, currentPage, pageSize);
    }

    /**
     * 查找角色下的机构
     *
     * @param code          角色 code
     * @param namespaceCode 权限组 code
     */
    public PageResult<Org> roleWithOrgs(String code, String namespaceCode, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/roleWithOrgs");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("namespaceCode", namespaceCode);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<Org>>() {
        });
    }

    /**
     * 查找角色下的分组
     *
     * @param code 角色 code
     */
    public PageResult<Group> roleWithGroups(String code, int currentPage, int pageSize) {
        return roleWithGroups(code, null, currentPage, pageSize);
    }

    /**
     * 查找角色下的分组
     *
     * @param code          角色 code
     * @param namespaceCode 权限组 code
     */
    public PageResult<Group> roleWithGroups(String code, String namespaceCode, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/roleWithGroups");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("namespaceCode", namespaceCode);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<Group>>() {
        });
    }

    /**
     * 查找用户的全部角色信息列表
     *
     * @param userId 用户 ID
     */
    public List<UserRoleInfo> userRoleList(String userId) {
        return userRoleList(userId, null);
    }

    /**
     * 查找用户指定权限组下的角色信息列表
     *
     * @param userId        用户 ID
     * @param namespaceCode 权限组 code
     */
    public List<UserRoleInfo> userRoleList(String userId, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/role/getUserRoleList");
        Map<String, Object> param = new HashMap<>(2);
        param.put("userId", userId);
        param.put("namespaceCode", namespaceCode);
        return this.managementClient.get(url, param, new TypeReference<List<UserRoleInfo>>() {
        });
    }

    public RoleManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
