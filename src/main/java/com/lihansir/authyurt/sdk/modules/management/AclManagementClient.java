package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import com.lihansir.authyurt.sdk.enums.ResourceType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限控制客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class AclManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建权限组
     */
    public ResourceNamespace createNamespace(CreateResourceNamespaceParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/create");
        return this.managementClient.post(url, param, ResourceNamespace.class);
    }

    /**
     * 修改权限组
     */
    public ResourceNamespace updateNamespace(String code, UpdateResourceNamespaceParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/" + code);
        return this.managementClient.put(url, param, ResourceNamespace.class);
    }

    /**
     * 权限组详情
     */
    public ResourceNamespace namespaceDetail(String code) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/detail/" + code);
        return this.managementClient.get(url, ResourceNamespace.class);
    }

    /**
     * 删除权限组
     */
    public void deleteNamespace(String code) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/deleteByCode/" + code);
        this.managementClient.delete(url);
    }

    /**
     * 搜索权限组
     *
     * @param query 关键字（按名称搜索）
     */
    public PageResult<ResourceNamespace> searchNamespace(String query, int currentPage, int pageSize) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/search");
        Map<String, Object> param = new HashMap<>(3);
        param.put("query", query);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return this.managementClient.get(url, param, new TypeReference<PageResult<ResourceNamespace>>() {
        });
    }

    /**
     * 获取全部权限组信息
     */
    public List<ResourceNamespace> allNamespace() {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource-namespace/all");
        return this.managementClient.get(url, new TypeReference<List<ResourceNamespace>>() {
        });
    }

    /**
     * 创建资源
     */
    public Resource createResource(CreateResourceParam param) {
        String namespaceCode = param.getNamespaceCode();
        if (StrUtil.isBlank(namespaceCode)) {
            namespaceCode = CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE;
        }
        Resource resource = Resource.builder()
                .code(param.getCode())
                .type(param.getType().getValue())
                .description(param.getDescription())
                .actions(param.getActions())
                .apiIdentifier(param.getApiIdentifier())
                .build();
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource/" + namespaceCode);
        return this.managementClient.post(url, resource, Resource.class);
    }

    /**
     * 修改资源
     *
     * @param resourceCode 资源 code
     */
    public Resource updateResource(String resourceCode, UpdateResourceParam param) {
        String namespaceCode = param.getNamespaceCode();
        if (StrUtil.isBlank(namespaceCode)) {
            namespaceCode = CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE;
        }
        Resource resource = Resource.builder()
                .code(param.getCode())
                .type(param.getType().getValue())
                .description(param.getDescription())
                .actions(param.getActions())
                .apiIdentifier(param.getApiIdentifier())
                .build();
        String url = StrUtil.format("{}{}?namespaceCode={}", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/resource/update/" + resourceCode, namespaceCode);
        return this.managementClient.put(url, resource, Resource.class);
    }

    /**
     * 获取资源列表
     *
     * @param namespaceCode 权限组 code
     */
    public PageResult<Resource> listResource(String namespaceCode, ListResourceOptions options) {
        ResourceType type = options.getType();
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource/findByPage");
        Map<String, Object> param = new HashMap<>(3);
        param.put("namespaceCode", namespaceCode);
        param.put("type", type == null ? null : type.getValue());
        param.put("currentPage", options.getCurrentPage());
        param.put("pageSize", options.getPageSize());
        return this.managementClient.get(url, param, new TypeReference<PageResult<Resource>>() {
        });
    }

    /**
     * 获取全部资源
     *
     * @param namespaceCode 权限组 code
     */
    public List<Resource> allResource(String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource/findAllByNamespaceCode");
        Map<String, Object> param = new HashMap<>(1);
        param.put("namespaceCode", namespaceCode);
        return this.managementClient.get(url, param, new TypeReference<List<Resource>>() {
        });
    }

    /**
     * 资源详情
     *
     * @param resourceCode  资源名称
     * @param namespaceCode 权限组 code
     */
    public Resource resourceDetail(String resourceCode, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource/detail");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", resourceCode);
        param.put("namespaceCode", namespaceCode);
        return this.managementClient.get(url, param, Resource.class);
    }

    /**
     * 删除资源
     *
     * @param resourceCode  资源名称
     * @param namespaceCode 权限组 code
     */
    public void deleteResource(String resourceCode, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/resource");
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", resourceCode);
        param.put("namespaceCode", namespaceCode);
        this.managementClient.deleteWithParam(url, param);
    }

    /**
     * 允许应用访问权限
     */
    public void allowApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        allowApplicationAccess(applicationId, targetType, targetIds, null);
    }

    /**
     * 允许应用访问权限
     */
    public void allowApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds,
                                       AllowApplicationAccessOptions options) {
        String url = StrUtil.format("{}{}/{}/allow", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> data = new HashMap<>(4);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.put("targetNamespaceCode", options.getTargetNamespaceCode());
            data.put("inherit", options.getInherit());
        }
        this.managementClient.post(url, data);
    }

    /**
     * 拒绝应用访问权限
     */
    public void disableApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        disableApplicationAccess(applicationId, targetType, targetIds, null);
    }

    /**
     * 拒绝应用访问权限
     */
    public void disableApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds,
                                         DisableApplicationAccessOptions options) {
        String url = StrUtil.format("{}{}/{}/deny", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> data = new HashMap<>(4);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.put("targetNamespaceCode", options.getTargetNamespaceCode());
            data.put("inherit", options.getInherit());
        }
        this.managementClient.post(url, data);
    }

    /**
     * 撤销应用访问权限
     */
    public void revokeApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        revokeApplicationAccess(applicationId, targetType, targetIds, null);
    }

    /**
     * 撤销应用访问权限
     */
    public void revokeApplicationAccess(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds,
                                        RevokeApplicationAccessOptions options) {
        String url = StrUtil.format("{}{}/{}/revoke", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> data = new HashMap<>(3);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.put("targetNamespaceCode", options.getTargetNamespaceCode());
        }
        this.managementClient.post(url, data);
    }

    /**
     * 启用应用访问权限
     */
    public void enableApplicationEffect(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        enableApplicationEffect(applicationId, targetType, targetIds, null);
    }

    /**
     * 启用应用访问权限
     */
    public void enableApplicationEffect(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds,
                                        EnableApplicationEffectOptions options) {
        String url = StrUtil.format("{}{}/{}/enable-effect", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> data = new HashMap<>(3);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.put("targetNamespaceCode", options.getTargetNamespaceCode());
        }
        this.managementClient.post(url, data);
    }

    /**
     * 禁用应用访问权限
     */
    public void disableApplicationEffect(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        disableApplicationEffect(applicationId, targetType, targetIds, null);
    }

    /**
     * 禁用应用访问权限
     */
    public void disableApplicationEffect(String applicationId, PolicyAssignmentTargetType targetType, List<String> targetIds,
                                         DisableApplicationEffectOptions options) {
        String url = StrUtil.format("{}{}/{}/disable-effect", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> data = new HashMap<>(3);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.put("targetNamespaceCode", options.getTargetNamespaceCode());
        }
        this.managementClient.post(url, data);
    }

    /**
     * 获取应用授权列表
     *
     * @param applicationId 应用 ID
     */
    public PageResult<PolicyAssignmentResult> applicationAuthorizationAssignments(String applicationId) {
        return applicationAuthorizationAssignments(applicationId, null);
    }

    /**
     * 获取应用授权列表
     *
     * @param applicationId 应用 ID
     */
    public PageResult<PolicyAssignmentResult> applicationAuthorizationAssignments(String applicationId, ApplicationAuthorizationAssignmentsOptions options) {
        String url = StrUtil.format("{}{}/{}/records", CommonConstant.CONSOLE_CONTEXT_PATH,
                "/api/application-authorization", applicationId);
        Map<String, Object> param = new HashMap<>(2);
        if (options != null) {
            param.put("currentPage", options.getCurrentPage());
            param.put("pageSize", options.getPageSize());
            param.put("targetType", options.getTargetType());
        }
        return this.managementClient.get(url, param, new TypeReference<PageResult<PolicyAssignmentResult>>() {
        });
    }

    /**
     * 判断某个用户是否对某个资源有某个操作权限
     *
     * @param userId   用户 ID
     * @param resource 资源 例：order:1234
     * @param action   操作 例：order:create
     * @return 是否允许
     */
    public boolean isAllowed(String userId, String resource, String action) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/isAllowed");
        Map<String, Object> data = new HashMap<>(3);
        data.put("userId", userId);
        data.put("resource", resource);
        data.put("action", action);
        return this.managementClient.post(url, data, Boolean.class);
    }

    /**
     * 允许某个用户、机构、角色、用户分组对某个资源进行某个操作
     */
    public void allow(AllowResourceParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/allow");
        this.managementClient.post(url, param);
    }

    public AclManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
