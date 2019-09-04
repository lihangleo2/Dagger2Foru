package com.lihang.dagger2stu.study.dstudy;


import com.lihang.dagger2stu.study.cstudy.CstudyModule;

import dagger.Component;

/**
 * Created by leo
 * on 2019/8/30.
 */
@Component(modules = CstudyModule.class)
public interface DstudyActivityComponent {
    void injectTo(DstudyActivity dstudyActivity);

    @Component.Builder
    interface Builder {
        Builder cstudyModule(CstudyModule cstudyModule);
        DstudyActivityComponent build();
    }
}
