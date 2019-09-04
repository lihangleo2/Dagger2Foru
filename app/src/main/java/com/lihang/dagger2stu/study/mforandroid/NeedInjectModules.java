package com.lihang.dagger2stu.study.mforandroid;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by leo
 * on 2019/9/4.
 */
@Module
public abstract class NeedInjectModules {
    @ContributesAndroidInjector
    abstract ForAndroidActivity inject();
}
