package com.lihang.dagger2stu.study.kstudy.applicationsingleton;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
