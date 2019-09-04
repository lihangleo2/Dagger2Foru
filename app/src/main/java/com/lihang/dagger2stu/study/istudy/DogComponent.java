package com.lihang.dagger2stu.study.istudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(modules = DogModule.class)
public interface DogComponent {
    void inject(IstudyActivity istudyActivity);
}
