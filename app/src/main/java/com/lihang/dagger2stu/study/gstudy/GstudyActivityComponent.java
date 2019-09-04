package com.lihang.dagger2stu.study.gstudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(modules = GstudyActivityModule.class)
public interface GstudyActivityComponent {
    DemoFragmentComponent demoFragmentComponent();
}
