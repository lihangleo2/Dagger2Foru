package com.lihang.dagger2stu.study.fstudy;

import com.lihang.dagger2stu.study.bstudy.Human;

import dagger.Component;

/**
 * Created by leo
 * on 2019/9/3.
 */
@Component(modules = FstudyActivityModule.class)
public interface FstudyActivityComponent {
    Human provideHuman();
}
