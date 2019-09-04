package com.lihang.dagger2stu.study.bstudy;

import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Component(modules = BstudyActivityModule.class)
public interface BstudyActivityComponent {
    void injectTo(BstudyActivity bstudyActivity);
}
