package com.lihang.dagger2stu.study.gstudy;

import com.lihang.dagger2stu.study.bstudy.Human;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Module
public class GstudyActivityModule {
    @Provides
    Human providesHuman() {
        return new Human();
    }
}
