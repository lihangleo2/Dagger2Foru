package com.lihang.dagger2stu.study.hstudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(modules = HstudyActivityModule.class)
public interface HstudyActivityComponent {
    OtherFragmentComponent.Builder sonbuilder();
}
