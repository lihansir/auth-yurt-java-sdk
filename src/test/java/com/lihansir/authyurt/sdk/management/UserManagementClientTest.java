package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.CreateUserParam;
import com.lihansir.authyurt.sdk.model.PageResult;
import com.lihansir.authyurt.sdk.model.UpdateUserParam;
import com.lihansir.authyurt.sdk.model.User;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import com.lihansir.authyurt.sdk.modules.management.UserManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * 用户管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class UserManagementClientTest {

    private UserManagementClient userManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.userManagementClient = managementClient.user();
    }

    @Test
    public void detail() {
        User detail = this.userManagementClient.detail("1522416894286630912");
        Assert.notBlank(detail.getId());
    }

    @Test
    public void create() {
        CreateUserParam createUserParam = CreateUserParam.builder().username("test").password("test").build();
        User user = this.userManagementClient.create(createUserParam);
        Assert.notBlank(user.getId());
    }

    @Test
    public void update() {
        UpdateUserParam updateUserParam = UpdateUserParam.builder().nickname("test-update").build();
        User update = this.userManagementClient.update("1522416894286630912", updateUserParam);
        Assert.isTrue(Objects.equals(update.getNickname(), "test-update"));
    }

    @Test
    public void delete() {
        this.userManagementClient.delete("1522416894286630912");
    }

    @Test
    public void deleteMany() {
        this.userManagementClient.deleteMany(Arrays.asList("1522181320405553153", "1522181256668909568"));
    }

    @Test
    public void search() {
        PageResult<User> search = this.userManagementClient.search("test", 1, 10);
        Assert.notEmpty(search.getData());
    }

    @Test
    public void kick() {
        this.userManagementClient.kick(Collections.singletonList("1522181320405553153"));
    }

}
