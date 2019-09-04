package com.lihang.dagger2stu.study.fstudy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;

/**
 * Created by leo
 * on 2019/9/3.
 */
//这里是：TestFragmentComponent 依赖 FstudyActivityComponent
//1、假设我们用Human注入，这里的FstudyActivityModule 和之前的Module一样，正常
//2、FstudyActivityComponent把要注入的类返回
//3、在TestFragment方面，我们新建一个TestFragmentComponent 依赖 FstudyActivityComponent;
//4、在FstudyActivity自定义一个方法把FstudyActivityComponent提供出去，供TestFragment使用
//5、在TestFragment,注册下就OK了。很绕，个人建议先明白这个流程就好了

public class FstudyActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private TestFragment testFragment;
    //
    private FstudyActivityComponent fstudyActivityComponent;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_f);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_f;
    }

    @Override
    protected void processLogic() {
        fstudyActivityComponent = DaggerFstudyActivityComponent.create();

        testFragment = new TestFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout, testFragment);
        ft.show(testFragment);
        ft.commit();
    }

    public FstudyActivityComponent getFstudyActivityComponent() {
        return fstudyActivityComponent;
    }
}
