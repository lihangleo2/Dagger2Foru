package com.lihang.dagger2stu.study.kstudy.applicationsingleton;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Singleton
@Component(modules = ApplicationMoule.class)
public interface ApplicationComponent {
    SurperMan provideSurperMan();
}
