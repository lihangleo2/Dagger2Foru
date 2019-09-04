package com.lihang.dagger2stu.study.cstudy;

/**
 * Created by leo
 * on 2019/8/29.
 */
//女人拥有灵魂
public class Woman {
    private Soul soul;

    public Soul getSoul() {
        return soul;
    }

    public Woman(Soul soul) {
        this.soul = soul;
    }
}
