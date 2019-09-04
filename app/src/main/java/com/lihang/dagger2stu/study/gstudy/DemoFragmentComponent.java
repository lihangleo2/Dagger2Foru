package com.lihang.dagger2stu.study.gstudy;

import dagger.Subcomponent;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Subcomponent
public interface DemoFragmentComponent {
    void inject(DemoFragment demoFragment);
}
