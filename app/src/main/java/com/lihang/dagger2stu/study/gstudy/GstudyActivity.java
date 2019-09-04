package com.lihang.dagger2stu.study.gstudy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;

/**
 * Created by leo
 * on 2019/9/3.
 */
//同样这里用activity 和 fragment 举例。GstudyActivityModule 正常，和之前一样
//1、先建一个子类Component,用@subComponent标注，DemoFragmentComponent
//2、然后建父类Component: GstudyActivityComponent,定义个方法，返回子类Component。
//3、在GstudyActivity自定义一个方法把GstudyActivityComponent提供出去，供DemoFragment使用
//4、在DemoFragment,注册下,就好了。大致和dependencies类似
// 注意：但注册的时候写法不同，之前是通过子Component传入父Component；
//       而这里是从父Component中获取子Component，然后直接inject

public class GstudyActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private DemoFragment demoFragment;
    //
    private GstudyActivityComponent gstudyActivityComponent;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_g);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_f;
    }

    @Override
    protected void processLogic() {
        gstudyActivityComponent = DaggerGstudyActivityComponent.builder().build();

        demoFragment = new DemoFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout, demoFragment);
        ft.show(demoFragment);
        ft.commit();
    }

    public GstudyActivityComponent getGstudyActivityComponent() {
        return gstudyActivityComponent;
    }
}
