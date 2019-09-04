package com.lihang.dagger2stu.study.kstudy.activitysingleton;

import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/3.
 */

@Module
public class ActivityModule {
    @ApplicationScope
    @Provides
    Children ProvidesChildren(){
        return new Children();
    }
}
