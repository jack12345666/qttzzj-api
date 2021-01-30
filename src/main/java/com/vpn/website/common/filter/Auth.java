package com.vpn.website.common.filter;

import com.vpn.website.client.enums.AuthTypeEnum;

import java.lang.annotation.*;

/**
 * 用户拦截
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    // 用户类型限制 0 表示不限制  1 要求政府访问  2 要求企业访问
    AuthTypeEnum authtype() default AuthTypeEnum.NO_AUTH;
}
