package com.lihang.dagger2stu.study.cstudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Component(modules = CstudyModule.class)
public interface CstudyActivityComponent {
    void injectTo(CstudyActivity cstudyActivity);
}
