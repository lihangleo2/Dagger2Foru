package com.lihang.dagger2stu.study.cstudy;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leo
 * on 2019/8/29.
 */
@Module
public class CstudyModule {
    private int money;

    public CstudyModule(int money) {
        this.money = money;
    }
    @Provides
    Soul providesSoul() {
        Soul soul = new Soul();
        soul.setMoney(this.money);
        return soul;
    }

    @Provides
    Woman providesWoman(Soul soul) {
        return new Woman(soul);
    }
}
