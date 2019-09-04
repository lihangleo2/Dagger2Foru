package com.lihang.dagger2stu.study.hstudy;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Subcomponent
public interface OtherFragmentComponent {
    void inject(OtherFragment otherFragment);
    @Subcomponent.Builder
    interface Builder {
        OtherFragmentComponent build();
    }
}
