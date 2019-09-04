package com.lihang.dagger2stu.study.istudy;

import java.io.Serializable;

/**
 * Created by leo
 * on 2019/9/3.
 */
public class Dog implements Serializable {
    private String Type;

    public Dog(String type) {
        this.Type = type;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
