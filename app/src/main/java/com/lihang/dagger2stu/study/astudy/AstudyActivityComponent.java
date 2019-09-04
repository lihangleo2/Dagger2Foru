package com.lihang.dagger2stu.study.astudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Component
public interface AstudyActivityComponent {
    void injectTo(AstudyActivity astudyActivity);
}
