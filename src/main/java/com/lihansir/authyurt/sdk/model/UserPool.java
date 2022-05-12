package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.UserPoolPackageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户池
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPool {

    /**
     * 用户池 ID
     */
    private String id;

    /**
     * 用户池密钥
     */
    private String secret;

    /**
     * 用户池持有者 ID
     */
    private String userId;

    private String logo;

    /**
     * 用户池名称
     */
    private String name;

    /**
     * 唯一标识符
     */
    private String identifier;

    private String description;

    /**
     * 用户池套餐
     */
    private UserPoolPackageType packageType;

    /**
     * (CORS) 多个请用换行符分割，如：
     * https://example.com
     * https://*.example.com
     */
    private String allowedOrigins;

    /**
     * cookie 过期时间：浏览器会话
     */
    private Boolean casExpireBaseBrowser;

    /**
     * cookie 过期时间 单位/秒
     */
    private Long casExpire;

    /**
     * 默认设置新注册的邮箱为已验证
     */
    private Boolean emailVerifiedDefault;

    /**
     * 注册时发送欢迎邮件
     */
    private Boolean sendWelcomeEmail;

    /**
     * 禁用注册
     */
    private Boolean registerDisabled;

    /**
     * 禁止未验证邮箱的用户登录
     */
    private Boolean loginRequireEmailVerified;

    /**
     * 密码强度
     *
     * 1、用户可使用任意非空字符串作为密码
     *
     * 2、自定义密码强度规则
     *
     * 3、用户须使用至少 6 位字符作为密码
     *
     * 4、用户须使用至少 6 位字符作为密码，须包含英文、数字与符号中的两种
     *
     * 5、用户须使用至少 6 位字符作为密码，且密码中须包含英文大小写、数字与符号
     *
     */
    private Integer passwordStrength;

    /**
     * 自定义密码强度。仅 passwordStrength 为 2 时生效
     */
    private CustomPasswordStrength customPasswordStrength;

    public Long gmtCreate;

    public Long gmtModified;

}
