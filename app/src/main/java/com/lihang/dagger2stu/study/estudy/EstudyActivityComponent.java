package com.lihang.dagger2stu.study.estudy;


import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by leo
 * on 2019/8/30.
 */
@Component(modules = EstudyModule.class)
public interface EstudyActivityComponent {
    void injectTo(EstudyActivity estudyActivity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder initMoney(int money);
        EstudyActivityComponent build();
    }
}
