package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import com.lihansir.authyurt.sdk.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 策略管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class PolicyManagementClient {

    private final ManagementClient managementClient;

    /**
     * 创建策略
     */
    public PolicyDetail createPolicy(CreatePolicyParam param) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy");
        return this.managementClient.post(url, param, PolicyDetail.class);
    }

    /**
     * 修改策略
     */
    public PolicyDetail updatePolicy(String code, UpdatePolicyParam updateParam) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/" + code);
        return this.managementClient.post(url, updateParam, PolicyDetail.class);
    }

    /**
     * 删除策略
     */
    public void deletePolicy(List<String> codes) {
        deletePolicy(codes, null);
    }

    /**
     * 删除策略
     */
    public void deletePolicy(List<String> codes, String namespaceCode) {
        if (CollUtil.isEmpty(codes)) {
            return;
        }
        String url = StrUtil.format("{}{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/",
                ArrayUtil.join(codes.toArray(), ","));
        Map<String, Object> data = new HashMap<>(1);
        data.put("namespaceCode", namespaceCode);
        this.managementClient.delete(url, data);
    }

    /**
     * 策略详情
     *
     * @param code 策略 code
     */
    public PolicyDetail policyDetail(String code) {
        return policyDetail(code, null);
    }

    /**
     * 策略详情
     *
     * @param code          策略 code
     * @param namespaceCode 权限组 code
     */
    public PolicyDetail policyDetail(String code, String namespaceCode) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/" + code);
        Map<String, Object> param = new HashMap<>(1);
        param.put("namespaceCode", namespaceCode);
        return this.managementClient.get(url, param, PolicyDetail.class);
    }

    /**
     * 获取策略列表
     */
    public List<PolicyDetail> policyList() {
        return policyList(null);
    }

    /**
     * 获取策略列表
     */
    public List<PolicyDetail> policyList(PolicyListParam policyListParam) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/getPolicies");
        Map<String, Object> param = new HashMap<>(2);
        if (policyListParam != null) {
            param.put("namespaceCode", policyListParam.getNamespaceCode());
            param.put("systemDefault", policyListParam.getSystemDefault());
        }
        return this.managementClient.get(url, param, new TypeReference<List<PolicyDetail>>() {
        });
    }

    /**
     * 授予策略
     *
     * @param codes      策略 code
     * @param targetType 授予目标类型
     * @param targetIds  授予目标 ID。当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     *                   当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 options 中的 namespaceCode；
     *                   当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    public void assignPolicy(List<String> codes, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        assignPolicy(codes, targetType, targetIds, null);
    }

    /**
     * 授予策略
     *
     * @param codes      策略 code
     * @param targetType 授予目标类型
     * @param targetIds  授予目标 ID。当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     *                   当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 options 中的 namespaceCode；
     *                   当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    public void assignPolicy(List<String> codes, PolicyAssignmentTargetType targetType, List<String> targetIds, AssignPolicyOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/assignments");
        Map<String, Object> data = new HashMap<>(8);
        data.put("codes", codes);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.putAll(BeanUtil.beanToMap(options));
        }
        this.managementClient.post(url, data);
    }

    /**
     * 删除策略授权
     *
     * @param codes      策略 code
     * @param targetType 授予目标类型
     * @param targetIds  授予目标 ID。当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     *                   当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 options 中的 namespaceCode；
     *                   当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    public void removePolicyAssignments(List<String> codes, PolicyAssignmentTargetType targetType, List<String> targetIds) {
        removePolicyAssignments(codes, targetType, targetIds, null);
    }

    /**
     * 删除策略授权
     *
     * @param codes      策略 code
     * @param targetType 授予目标类型
     * @param targetIds  授予目标 ID。当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     *                   当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 options 中的 namespaceCode；
     *                   当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    public void removePolicyAssignments(List<String> codes, PolicyAssignmentTargetType targetType,
                                        List<String> targetIds, RemovePolicyAssignmentsOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/removePolicyAssignments");
        Map<String, Object> data = new HashMap<>(4);
        data.put("codes", codes);
        data.put("targetType", targetType);
        data.put("targetIds", targetIds);
        if (options != null) {
            data.putAll(BeanUtil.beanToMap(options));
        }
        this.managementClient.post(url, data);
    }

    /**
     * 获取策略授权列表
     */
    public PageResult<PolicyAssignmentResult> getPolicyAssignments() {
        return getPolicyAssignments(null);
    }

    /**
     * 获取策略授权列表
     */
    public PageResult<PolicyAssignmentResult> getPolicyAssignments(GetPolicyAssignmentsOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/getAssignments");
        Map<String, Object> param = new HashMap<>(6);
        if (options != null) {
            param.putAll(BeanUtil.beanToMap(options));
        }
        return this.managementClient.get(url, param, new TypeReference<PageResult<PolicyAssignmentResult>>() {
        });
    }

    /**
     * 通过授权目标查看授予的策略信息
     */
    public PolicyAssignmentResult getPolicyAssignmentsByTarget(String code) {
        return getPolicyAssignmentsByTarget(code, null);
    }

    /**
     * 通过授权目标查看授予的策略信息
     */
    public PolicyAssignmentResult getPolicyAssignmentsByTarget(String code, GetPolicyAssignmentsByTargetOptions options) {
        String url = StrUtil.format("{}{}", CommonConstant.CONSOLE_CONTEXT_PATH, "/api/policy/assignments/by-target");
        Map<String, Object> param = new HashMap<>(4);
        param.put("code", code);
        if (options != null) {
            param.putAll(BeanUtil.beanToMap(options));
        }
        return this.managementClient.get(url, param, PolicyAssignmentResult.class);
    }

    public PolicyManagementClient(ManagementClient managementClient) {
        this.managementClient = managementClient;
    }

}
