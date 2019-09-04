package com.lihang.dagger2stu.study.kstudy.activitysingleton;

import com.lihang.dagger2stu.study.kstudy.KstudyActivity;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationComponent;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationMoule;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@ApplicationScope
@Component(modules = ActivityModule.class,dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(KstudyActivity kstudyActivity);
}
