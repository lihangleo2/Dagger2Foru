package com.lihang.dagger2stu.study.bstudy;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Module
public class BstudyActivityModule {
    //什么时候使用@Provides 比如你使用的第三方库，或者你的类没有使用注解@Inject时
    @Provides
    Human getHuman(){
       return new Human();
    }
}
