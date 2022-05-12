package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import com.lihansir.authyurt.sdk.enums.PolicyEffect;
import com.lihansir.authyurt.sdk.enums.ResourceType;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import com.lihansir.authyurt.sdk.modules.management.PolicyManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 策略管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class PolicyManagementClientTest {

    private PolicyManagementClient policyManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.policyManagementClient = managementClient.policy();
    }

    @Test
    public void createPolicy() {
        String policyCode = "test_policy_code";
        List<PolicyStatementParam> statements = new ArrayList<>();
        statements.add(PolicyStatementParam.builder()
                .resourceType(ResourceType.DATA.getValue())
                .resource("order:*")
                .effect(PolicyEffect.ALLOW)
                .actions(Collections.singletonList("order:create"))
                .build());
        CreatePolicyParam param = new CreatePolicyParam(policyCode, statements);
        PolicyDetail policyDetail = this.policyManagementClient.createPolicy(param);
        Assert.isTrue(Objects.equals(policyCode, policyDetail.getPolicy().getCode()));
    }

    @Test
    public void updatePolicy() {
        List<PolicyStatementParam> statements = new ArrayList<>();
        statements.add(PolicyStatementParam.builder()
                .resourceType(ResourceType.DATA.getValue())
                .resource("order:*")
                .effect(PolicyEffect.ALLOW)
                .actions(Collections.singletonList("order:delete"))
                .build());
        UpdatePolicyParam updateParam = new UpdatePolicyParam(statements);
        PolicyDetail policyDetail = this.policyManagementClient.updatePolicy("test_policy_code", updateParam);
        Assert.notEmpty(policyDetail.getStatements());
    }

    @Test
    public void deletePolicy() {
        this.policyManagementClient.deletePolicy(Collections.singletonList("test_policy_code"));
    }

    @Test
    public void policyDetail() {
        String policyCode = "test_policy_code";
        PolicyDetail policyDetail = this.policyManagementClient.policyDetail(policyCode);
        Assert.isTrue(Objects.equals(policyCode, policyDetail.getPolicy().getCode()));
    }

    @Test
    public void policyList() {
        List<PolicyDetail> policyDetails = this.policyManagementClient.policyList();
        Assert.notEmpty(policyDetails);
    }

    @Test
    public void assignPolicy() {
        this.policyManagementClient.assignPolicy(Collections.singletonList("test_policy_code"), PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void removePolicyAssignments() {
        this.policyManagementClient.removePolicyAssignments(Collections.singletonList("test_policy_code"), PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void getPolicyAssignments() {
        PageResult<PolicyAssignmentResult> policyAssignments = this.policyManagementClient.getPolicyAssignments();
        Assert.notEmpty(policyAssignments.getData());
    }

    @Test
    public void getPolicyAssignmentsByTarget() {
        PolicyAssignmentResult policyAssignmentsByTarget = this.policyManagementClient.getPolicyAssignmentsByTarget("test_policy_code");
        Assert.notEmpty(policyAssignmentsByTarget.getTargets());
    }

}
