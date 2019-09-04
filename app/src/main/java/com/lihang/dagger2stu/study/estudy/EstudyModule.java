package com.lihang.dagger2stu.study.estudy;


import com.lihang.dagger2stu.study.cstudy.Soul;
import com.lihang.dagger2stu.study.cstudy.Woman;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Module
public class EstudyModule {

    @Provides
    Soul providesSoul(int money) {
        Soul soul = new Soul();
        soul.setMoney(money);
        return soul;
    }

    @Provides
    Woman providesWoman(Soul soul) {
        return new Woman(soul);
    }
}
