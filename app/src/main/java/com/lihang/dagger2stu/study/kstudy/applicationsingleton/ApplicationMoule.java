package com.lihang.dagger2stu.study.kstudy.applicationsingleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Module
public class ApplicationMoule {
    @Singleton
    @Provides
    SurperMan provideSurperMan() {
        return new SurperMan();
    }
}
