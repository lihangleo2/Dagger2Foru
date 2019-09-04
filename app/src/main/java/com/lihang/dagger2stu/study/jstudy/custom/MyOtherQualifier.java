package com.lihang.dagger2stu.study.jstudy.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOtherQualifier {
}
