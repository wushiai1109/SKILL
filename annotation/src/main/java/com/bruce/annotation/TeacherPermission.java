package com.bruce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName TeacherPermission
 * @Description 教师权限，用户为管理员或者教师
 * @Author Bruce
 * @Date 2020/11/21 5:08 下午
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TeacherPermission {

}
