package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建用户可选参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserOptions {

    /**
     * 是否保持密码不加密存储至数据库（默认为 false）（可为空）
     */
    private Boolean keepPassword;

    /**
     * 发送首次登录信息（默认为 false）（可为空）
     */
    private Boolean sendFirstLoginInfo;

    /**
     * 首次登陆应用 ID（可为空）
     */
    private String applicationId;

}
