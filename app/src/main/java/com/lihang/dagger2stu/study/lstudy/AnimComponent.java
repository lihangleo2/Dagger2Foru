package com.lihang.dagger2stu.study.lstudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/4.
 */
@Component(modules = AnimModule.class)
public interface AnimComponent {
    void inject(LstudyActivity lstudyActivity);
}
