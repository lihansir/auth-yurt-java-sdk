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
 * 机构管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class OrgManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建机构
     */
    public Org create(CreateOrgParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org");
        return this.managementClient.post(url, param, Org.class);
    }

    /**
     * 修改机构
     *
     * @param id ID（节点 ID，非机构 ID）
     */
    public Org update(String id, UpdateOrgParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org");
        Map<String, Object> data = BeanUtil.beanToMap(param);
        data.put("id", id);
        return this.managementClient.post(url, data, Org.class);
    }

    /**
     * 机构详情
     *
     * @param id 节点 ID
     */
    public Org detailById(String id) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getOrgById/" + id);
        return this.managementClient.get(url, Org.class);
    }

    /**
     * 机构详情
     *
     * @param orgId 机构 ID
     */
    public Org detailByOrgId(String orgId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getOrgByOrgId/" + orgId);
        return this.managementClient.get(url, Org.class);
    }

    /**
     * 删除机构
     *
     * @param id 节点 ID
     */
    public void deleteById(String id) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/deleteOrgById/" + id);
        this.managementClient.delete(url);
    }

    /**
     * 删除机构
     *
     * @param orgId 机构 ID
     */
    public void deleteByOrgId(String orgId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/deleteOrgByOrgId/" + orgId);
        this.managementClient.delete(url);
    }

    /**
     * 获取全部机构列表
     */
    public List<Org> all() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getAllOrg");
        return this.managementClient.get(url, new TypeReference<List<Org>>() {
        });
    }

    /**
     * 通过机构节点 ID 列表获取全部机构列表
     */
    public List<Org> listByIds(List<String> ids) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getOrgByIdList");
        Map<String, Object> data = new HashMap<>(1);
        data.put("orgNodeIds", ids);
        return this.managementClient.post(url, data, new TypeReference<List<Org>>() {
        });
    }

    /**
     * 搜索机构
     */
    public List<Org> search(String query) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/searchOrg");
        Map<String, Object> param = new HashMap<>(1);
        param.put("query", query);
        return this.managementClient.get(url, param, new TypeReference<List<Org>>() {
        });
    }

    /**
     * 获取用户所属机构节点 ID 列表
     *
     * @param userId 用户 ID
     */
    public List<String> listUserOrgNodeIds(String userId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getOrgNodeIdListByUserId");
        Map<String, Object> param = new HashMap<>(1);
        param.put("userId", userId);
        return this.managementClient.get(url, param, new TypeReference<List<String>>() {
        });
    }

    /**
     * 将用户添加到机构下
     *
     * @param id      机构节点 ID
     * @param userIds 用户 ID 列表
     */
    public void addMembers(String id, List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/addMembers");
        Map<String, Object> data = new HashMap<>(2);
        data.put("orgNodeId", id);
        data.put("userIds", userIds);
        this.managementClient.post(url, data);
    }

    /**
     * 将用户从机构中移除
     *
     * @param id      机构节点 ID
     * @param userIds 用户 ID 列表
     */
    public void removeMembers(String id, List<String> userIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/deleteOrgMembers");
        Map<String, Object> data = new HashMap<>(2);
        data.put("orgNodeId", id);
        data.put("userIds", userIds);
        this.managementClient.delete(url, data);
    }

    /**
     * 修改用户所属机构列表
     *
     * @param userId     用户 ID
     * @param orgNodeIds 用户所属机构节点 ID 列表
     */
    public void updateUserOrgs(String userId, List<String> orgNodeIds) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/updateUserOrgs");
        Map<String, Object> data = new HashMap<>(2);
        data.put("userId", userId);
        data.put("orgNodeIds", orgNodeIds);
        this.managementClient.post(url, data);
    }

    /**
     * 将用户从全部机构中移除
     *
     * @param userId 用户 ID
     */
    public void removeUserAllOrgs(String userId) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/deleteOrgUserByUserId");
        Map<String, Object> param = new HashMap<>(1);
        param.put("userId", userId);
        this.managementClient.deleteWithParam(url, param);
    }

    /**
     * 获取机构下的用户列表
     *
     * @param id 机构节点 ID
     */
    public PageResult<User> listOrgUsers(String id, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/org/getUsers");
        Map<String, Object> param = new HashMap<>(3);
        param.put("id", id);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<User>>() {
        });
    }

    public OrgManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
