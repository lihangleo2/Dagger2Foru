package com.lihang.dagger2stu.study.istudy;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Module
public class DogModule {

    @Named("tag_1")
    @Provides
    Dog providesJinDog(){
        return new Dog("金毛");
    }

    @Named("tag_2")
    @Provides
    Dog providesEhaDog(){
        return new Dog("二哈");
    }

}
