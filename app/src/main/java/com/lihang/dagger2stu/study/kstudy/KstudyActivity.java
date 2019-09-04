package com.lihang.dagger2stu.study.kstudy;

import com.lihang.dagger2stu.MyApplication;
import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.study.kstudy.activitysingleton.ActivityComponent;
import com.lihang.dagger2stu.study.kstudy.activitysingleton.Children;
import com.lihang.dagger2stu.study.kstudy.activitysingleton.DaggerActivityComponent;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.ApplicationComponent;
import com.lihang.dagger2stu.study.kstudy.applicationsingleton.SurperMan;
import com.lihang.dagger2stu.utils.LogUtils;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by leo
 * on 2019/9/3.
 */
//首先想说的是@Singleton是@Scope的一种，其源码如下：
//@Scope  //注明是Scope
//@Documented   //标记文档提示
//@Retention(RUNTIME)  //运行时候级别
//public @interface Singleton {}
//
//特别注意：@Singleton 是作用域单例,是作用域单例,是作用域单例(也可以理解为生命周期。注册在哪就跟他的生命周期绑定)
//          1、Component在Activity里build，那么这个单例只限于在这个Activity里。
//          意思退出这个Activity，再进这个Activity时，这个单例会被重新new
//          2、如果Component在Application里build，那么这个单例就是全局的。注意这里涉及到了我们之前的Component依赖Component。
//使用：
//1、不使用Module的情况：
//          在要单例的类上加上@Singleton,然后在构造方法加上@Inject。然后在@Component上加上@Singleton
//2、使用Module的情况：
//          你要单例的类什么都不用加，记住是什么都不用加。然后在Module的@Provides上加上@Singleton，然后在@Component上加上@Singleton
//小建议：个人建议使用带Module的。因为我在这里展示的时候，使用了2个单例，用方法1的时候，好像对比起来不是很清晰。代码清晰最重要！
//
//
//全局单例使用：
//          还记的Component依赖Component吗？这里的FatherComponent在Application里build。提供一个方法返回FatherComponent，
//          然后在要使用的Activity里，获取FatherComponent，对SonComponent,进行build。
//
//特别注意：这里我把局部单例 和 全局单例放在一起创建了，便于demo的讲解。在ActivityComponent里，
//          正常的局部单例@Component上加@Singleton就可以了。但是这里还用到了dependencies。如果继续用@Singleton，会报错，如下：
//
//          This @Singleton component cannot depend on scoped components
//
//          所以我们这里要自定义Scope。其实和@Singleton源码一样。具体为何报错，我还没有了解到。希望知道的小伙伴告知
//这里我简单的说下，ActivityComponent。
// 1、dependencies = ApplicationComponent.class；因为ApplicationComponent在Application生成的，ApplicationModule里的SurMan是全局单例
// 2、modules = ActivityModule.class；再由上面可以知道，我们要找到ActivityComponent是在哪生成的。
//    看看KstudyActivity里代码到这里：
//    DaggerActivityComponent.builder().applicationComponent(applicationComponent)
//            .build();
// 如果你还不清楚，我在换种写法：
//    ActivityComponent activityComponent = DaggerActivityComponent.builder().applicationComponent(applicationComponent)
//            .build();
// 所以ActivityComponent在KstudyActivity里build的；所以ActivityModule里的Children是局部单例

public class KstudyActivity extends BaseActivity {
    //作用域只在Activity里的单例
    @Inject
    Children children_1;
    @Inject
    Children children_2;
    //作用域在全局的单例
    @Inject
    SurperMan surperMan;


    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_k);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_k;
    }

    @Override
    protected void processLogic() {
        ApplicationComponent applicationComponent = ((MyApplication) getApplication()).getApplicationComponent();
        DaggerActivityComponent.builder().applicationComponent(applicationComponent)
                .build().inject(this);

        //全局单例
        LogUtils.i("看看hashCode值", "作用域在activity里的单例   children_1  hashCode ==>  " + children_1.hashCode());
        LogUtils.i("看看hashCode值", "作用域在activity里的单例   children_2  hashCode ==>  " + children_2.hashCode());
        LogUtils.i("看看hashCode值", "作用域在Application里的全局单例   surperMan  hashCode ==>  " + surperMan.hashCode() + "");

    }
}
