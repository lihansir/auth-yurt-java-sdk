package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import com.lihansir.authyurt.sdk.enums.ResourceType;
import com.lihansir.authyurt.sdk.modules.management.AclManagementClient;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 权限控制客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class AclManagementClientTest {

    private AclManagementClient aclManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.aclManagementClient = managementClient.acl();
    }

    @Test
    public void createNamespace() {
        CreateResourceNamespaceParam param = new CreateResourceNamespaceParam("test-create", "测试创建");
        ResourceNamespace namespace = this.aclManagementClient.createNamespace(param);
        Assert.notBlank(namespace.getId());
    }

    @Test
    public void updateNamespace() {
        String name = "测试修改";
        UpdateResourceNamespaceParam param = new UpdateResourceNamespaceParam();
        param.setName(name);
        ResourceNamespace resourceNamespace = this.aclManagementClient.updateNamespace("test-create", param);
        Assert.isTrue(Objects.equals(name, resourceNamespace.getName()));
    }

    @Test
    public void namespaceDetail() {
        ResourceNamespace namespace = this.aclManagementClient.namespaceDetail("test-create");
        Assert.notBlank(namespace.getId());
    }

    @Test
    public void deleteNamespace() {
        this.aclManagementClient.deleteNamespace("test-create");
    }

    @Test
    public void searchNamespace() {
        PageResult<ResourceNamespace> resourceNamespacePageResult = this.aclManagementClient.searchNamespace("测试", 1, 10);
        Assert.notEmpty(resourceNamespacePageResult.getData());
    }

    @Test
    public void allNamespace() {
        List<ResourceNamespace> resourceNamespaces = this.aclManagementClient.allNamespace();
        Assert.notEmpty(resourceNamespaces);
    }

    @Test
    public void createResource() {
        List<ResourceAction> actions = new ArrayList<>();
        ResourceAction resourceAction = new ResourceAction("order:read");
        actions.add(resourceAction);
        CreateResourceParam param = new CreateResourceParam("order", ResourceType.MENU);
        param.setActions(actions);
        Resource resource = this.aclManagementClient.createResource(param);
        Assert.notBlank(resource.getId());
    }

    @Test
    public void updateResource() {
        List<ResourceAction> actions = new ArrayList<>();
        ResourceAction resourceAction = new ResourceAction("order-update:read");
        actions.add(resourceAction);
        UpdateResourceParam param = new UpdateResourceParam("order-update", ResourceType.DATA);
        param.setActions(actions);
        Resource resource = this.aclManagementClient.updateResource("order", param);
        Assert.notBlank(resource.getId());
    }

    @Test
    public void listResource() {
        ListResourceOptions options = new ListResourceOptions();
        PageResult<Resource> resourcePageResult = this.aclManagementClient.listResource(CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE, options);
        Assert.notEmpty(resourcePageResult.getData());
    }

    @Test
    public void allResource() {
        List<Resource> resources = this.aclManagementClient.allResource(CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE);
        Assert.notEmpty(resources);
    }

    @Test
    public void resourceDetail() {
        Resource resource = this.aclManagementClient.resourceDetail("order", CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE);
        Assert.notBlank(resource.getId());
    }

    @Test
    public void deleteResource() {
        this.aclManagementClient.deleteResource("order", CommonConstant.DEFAULT_RESOURCE_NAMESPACE_CODE);
    }

    @Test
    public void allowApplicationAccess() {
        this.aclManagementClient.allowApplicationAccess(TestCommonConstant.TEST_APPLICATION_ID, PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void disableApplicationAccess() {
        this.aclManagementClient.disableApplicationAccess(TestCommonConstant.TEST_APPLICATION_ID, PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void revokeApplicationAccess() {
        this.aclManagementClient.revokeApplicationAccess(TestCommonConstant.TEST_APPLICATION_ID, PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void enableApplicationEffect() {
        this.aclManagementClient.enableApplicationEffect(TestCommonConstant.TEST_APPLICATION_ID, PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void disableApplicationEffect() {
        this.aclManagementClient.disableApplicationEffect(TestCommonConstant.TEST_APPLICATION_ID, PolicyAssignmentTargetType.USER,
                Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void applicationAuthorizationAssignments() {
        PageResult<PolicyAssignmentResult> policyAssignmentResultPageResult = this.aclManagementClient.applicationAuthorizationAssignments(TestCommonConstant.TEST_APPLICATION_ID);
        Assert.notEmpty(policyAssignmentResultPageResult.getData());
    }

    @Test
    public void isAllowed() {
        boolean allowed = this.aclManagementClient.isAllowed("1522418228675088384", "order:1", "order:create");
        Assert.isTrue(allowed);
    }

    @Test
    public void allow() {
        AllowResourceParam param = new AllowResourceParam("order:*", "order:create", PolicyAssignmentTargetType.USER, "1522418228675088384");
        this.aclManagementClient.allow(param);
    }

}
