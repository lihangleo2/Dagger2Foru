package com.lihang.dagger2stu;

import android.app.Application;
import android.content.Context;

import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationComponent;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.DaggerApplicationComponent;
import com.lihang.dagger2stu.study.mforandroid.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by leo
 * on 2019/8/22.
 */
public class MyApplication extends DaggerApplication {
    private static MyApplication context;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        applicationComponent = DaggerApplicationComponent.builder().build();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(MyApplication.this).build();
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


    public static Context getContext() {
        return context;
    }
}
