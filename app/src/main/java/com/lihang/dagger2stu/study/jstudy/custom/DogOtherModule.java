package com.lihang.dagger2stu.study.jstudy.custom;

import com.lihang.dagger2stu.study.istudy.Dog;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Module
public class DogOtherModule {
    @MyQualifier("tag_1")
    @Provides
    Dog providesJinDog(){
        return new Dog("金毛");
    }

    @MyQualifier("tag_2")
    @Provides
    Dog providesEhaDog(){
        return new Dog("二哈");
    }

    @MyQualifier("tag_3")
    @Provides
    String providesChina(){
        return "中华田园犬";
    }

    @Named("tag_4")
    @Provides
    String providesooDog(){
        return "藏獒";
    }

    @MyQualifier("tag_5")
    @Provides
    Dog providesfun(@MyQualifier("tag_3")String dogType){
        return new Dog(dogType);
    }


    @MyOtherQualifier
    @Provides
    Dog providesOtherQualifier(){
        return new Dog("萨摩耶");
    }

}
