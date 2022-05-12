package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.management.GroupManagementClient;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 用户分组管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class GroupManagementClientTest {

    private GroupManagementClient groupManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.groupManagementClient = managementClient.group();
    }

    @Test
    public void create() {
        String code = "test-create";
        CreateGroupParam param = new CreateGroupParam(code, "创建用户分组");
        Group group = this.groupManagementClient.create(param);
        Assert.isTrue(Objects.equals(code, group.getCode()));
    }

    @Test
    public void update() {
        String name = "修改用户分组";
        UpdateGroupParam param = new UpdateGroupParam("test-create");
        param.setName(name);
        Group group = this.groupManagementClient.update(param);
        Assert.isTrue(Objects.equals(name, group.getName()));
    }

    @Test
    public void detail() {
        Group detail = this.groupManagementClient.detail("test-create");
        Assert.notBlank(detail.getId());
    }

    @Test
    public void list() {
        PageResult<Group> list = this.groupManagementClient.list(1, 10);
        Assert.notEmpty(list.getData());
    }

    @Test
    public void all() {
        List<Group> all = this.groupManagementClient.all();
        Assert.notEmpty(all);
    }

    @Test
    public void delete() {
        this.groupManagementClient.delete("test-create");
    }

    @Test
    public void addMember() {
        this.groupManagementClient.addMember("test-create", Arrays.asList("1522418228675088384", "1522418173473853440"));
    }

    @Test
    public void removeMember() {
        this.groupManagementClient.removeMember("test-create", Arrays.asList("1522418228675088384", "1522418173473853440"));
    }

    @Test
    public void listUser() {
        PageResult<User> userPageResult = this.groupManagementClient.listUser("test-create", 1, 10);
        Assert.notEmpty(userPageResult.getData());
    }

    @Test
    public void listGroup() {
        PageResult<Group> groupPageResult = this.groupManagementClient.listGroup("1522418228675088384", 1, 10);
        Assert.notEmpty(groupPageResult.getData());
    }

}
