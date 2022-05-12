package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import com.lihansir.authyurt.sdk.modules.management.RoleManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 角色管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class RoleManagementClientTest {

    private RoleManagementClient roleManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.roleManagementClient = managementClient.role();
    }

    @Test
    public void create() {
        CreateRoleParam param = new CreateRoleParam("test-create");
        Role role = this.roleManagementClient.create(param);
        Assert.notBlank(role.getId());
    }

    @Test
    public void update() {
        String description = "test-update";
        UpdateRoleParam param = new UpdateRoleParam("test-create");
        param.setDescription(description);
        Role update = this.roleManagementClient.update(param);
        Assert.isTrue(Objects.equals(description, update.getDescription()));
    }

    @Test
    public void list() {
        PageResult<Role> list = this.roleManagementClient.list(1, 10);
        Assert.notEmpty(list.getData());
    }

    @Test
    public void detail() {
        Role detail = this.roleManagementClient.detail("test-create");
        Assert.notBlank(detail.getId());
    }

    @Test
    public void delete() {
        this.roleManagementClient.delete("test-create");
    }

    @Test
    public void assign() {
        AssignRoleParam param = new AssignRoleParam("test-create");
        param.setUserIds(Collections.singletonList("1522418228675088384"));
        param.setGroupCodes(Collections.singletonList("test-create"));
        param.setOrgNodeIds(Collections.singletonList("1522563872668651521"));
        this.roleManagementClient.assign(param);
    }

    @Test
    public void revoke() {
        RevokeRoleParam param = new RevokeRoleParam("test-create");
        param.setUserIds(Collections.singletonList("1522418228675088384"));
        param.setGroupCodes(Collections.singletonList("test-create"));
        param.setOrgNodeIds(Collections.singletonList("1522563872668651521"));
        this.roleManagementClient.revoke(param);
    }

    @Test
    public void roleWithUsers() {
        PageResult<User> userPageResult = this.roleManagementClient.roleWithUsers("test-create", 1, 10);
        Assert.notEmpty(userPageResult.getData());
    }

    @Test
    public void roleWithOrgs() {
        PageResult<Org> orgPageResult = this.roleManagementClient.roleWithOrgs("test-create", 1, 10);
        Assert.notEmpty(orgPageResult.getData());
    }

    @Test
    public void roleWithGroups() {
        PageResult<Group> groupPageResult = this.roleManagementClient.roleWithGroups("test-create", 1, 10);
        Assert.notEmpty(groupPageResult.getData());
    }

    @Test
    public void userRoleList() {
        List<UserRoleInfo> userRoleInfos = this.roleManagementClient.userRoleList("1522418228675088384");
        Assert.notEmpty(userRoleInfos);
    }

}
