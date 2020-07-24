package com.aaa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: RoleAnnotion
 * @author: 彭于晏
 * @create: 2020-07-21 19:01
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAnnotion {

    String roleName () default "";
}
