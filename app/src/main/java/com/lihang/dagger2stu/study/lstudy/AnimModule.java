package com.lihang.dagger2stu.study.lstudy;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/4.
 */
@Module
public class AnimModule {
    @Provides
    Cat catProvides() {
        return new Cat();
    }

    @Provides
    Pig pigProvides() {
        return new Pig();
    }

    @Provides
    Sheep sheepProvides() {
        return new Sheep();
    }
}
