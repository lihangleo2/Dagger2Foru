package com.lihang.dagger2stu.study.fstudy;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(dependencies = FstudyActivityComponent.class)
public interface TestFragmentComponent {
    void inject(TestFragment testFragment);
}
