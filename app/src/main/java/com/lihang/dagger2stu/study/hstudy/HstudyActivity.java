package com.lihang.dagger2stu.study.hstudy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.study.gstudy.DemoFragment;

import dagger.Subcomponent;

/**
 * Created by leo
 * on 2019/9/3.
 */
//还是以Activity 和 Fragment 为例
//1、首先我们回想一下@Component.Builder 的用法。@Subcomponent.Builder与其有些相似，但是又不一样
//2、先创建我们的子Component：OtherFragmentComponent，用@subComponent标注。同样定义接口Builder,并用@Subcomponent.Builder标注。
//注意：如果我们按照@Component.Builder的写法写的话，运行前一切正常，运行时会报错，报错信息如下：
//@Subcomponent.Builder types must have exactly one zero-arg method,
// and that method must return the @Subcomponent type. Already found: hstudyActivityModule()
// 所以这里的Builder只有一个方法：  以当前那个Component为返回值的方法
//3、创建我们的父Component：HstudyActivityComponent、其中定义的方法返回值为子Component.builder。
//   这里为什么不定义返回值为子Component ：OtherFragmentComponent；这里我们的标注是@Subcomponent.Builder
//   而且假如我们返回值是子Component的话，我们来看下报错信息，如下：
//   Components may not have factory methods for subcomponents that define a builder.
//   大概意思是用了@Subcomponent.Builder的话,Component没有工厂模式方法去创建。好了，大概这样
//4、在HstudyActivity自定义一个方法把HstudyActivityComponent提供出去，供OtherFragment使用
//5、在OtherFragment,注册下,就可以使用了。用这个更加绕，我只是介绍每个标注的意思及大致用法
//特别注意：这里有人会提了,我这里也要通过module传参，怎么办？
//咱们回去看下通过Module传值。这里要传的话，就是通过Module的构造函数，或者父Component通过@Component.Builder传值.
public class HstudyActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private OtherFragment otherFragment;
    //
    private HstudyActivityComponent hstudyActivityComponent;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_h);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_f;
    }

    @Override
    protected void processLogic() {
        hstudyActivityComponent = DaggerHstudyActivityComponent.create();

        otherFragment = new OtherFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout, otherFragment);
        ft.show(otherFragment);
        ft.commit();
    }

    public HstudyActivityComponent getHstudyActivityComponent() {
        return hstudyActivityComponent;
    }
}
