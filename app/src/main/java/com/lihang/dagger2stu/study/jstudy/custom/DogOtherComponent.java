package com.lihang.dagger2stu.study.jstudy.custom;

import com.lihang.dagger2stu.study.jstudy.JstudyActivity;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(modules = DogOtherModule.class)
public interface DogOtherComponent {
    void inject(JstudyActivity jstudyActivity);
}
