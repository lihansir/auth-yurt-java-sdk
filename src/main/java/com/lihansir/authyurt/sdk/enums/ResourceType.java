package com.lihansir.authyurt.sdk.enums;

/**
 * 资源类型
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum ResourceType {

    /**
     * 数据
     */
    DATA("data"),

    /**
     * API
     */
    API("api"),

    /**
     * 菜单
     */
    MENU("menu"),

    /**
     * 按钮
     */
    BUTTON("button");

    private final String value;

    ResourceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return value;
    }

}
