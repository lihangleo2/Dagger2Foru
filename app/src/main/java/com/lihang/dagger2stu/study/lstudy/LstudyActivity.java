package com.lihang.dagger2stu.study.lstudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.utils.LogUtils;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.OnClick;
import dagger.Lazy;

/**
 * Created by leo
 * on 2019/9/4.
 */
//普通Inject，Provider，Lazy的对比。为了对比明显，我们用一个Module。
//首先说下区别然后通过下面的例子具体说明下：
//   Provider：其实是一种工厂模式，如果不使用.get();在页面中使用其实和普通@Inject类似。但是每次调用.get()。
//             都会生成不同的实例；不调用不会生成实例，在页面里。我们@Inject的成员变量其实都调用了一次.get();
//   Lazy：懒加载，调用.get()。才生成实例，而且一旦实例生成，在调用。会一直使用已经生成的实例。
//         其实我们点开自动生成的源码DaggerAnimComponent，可以看到Provider和Lazy都用Provider去修饰的，
//         继续往下看到injectLstudyActivity这个方法里就有具体的区别了(DoubleCheck.lazy)：
//          LstudyActivity_MembersInjector.injectPig_1(instance, pigProvidesProvider);
//          LstudyActivity_MembersInjector.injectSheep_1(instance, DoubleCheck.lazy(sheepProvidesProvider));
//
//
//Demo：
//1、首先用@Inject标注cat_1，cat_2；用Provider修饰pig_1，pig_2；用Lazy修饰sheep_1，sheep_2。
//   然后我们重复进2次这个页面，看看hasCode值：
//从这里我们大概可以看到：
//   cat_1和cat_2每次都不一样，pig_1和pig_2也每次都不一样，sheep_1和sheep_2，在一个页面的时候是相同的。
//说明：
//   1.这个时候Lazy和局部单例有点类似。但是如果这里用@Qualifier标注不同的Lazy的话，还是会生成2个实例。这是他和局部单例最大的区别；
//   2.这里还有个就是Provider和普通的@Inject，看不出区别：
//      我们继续用个按钮打印pig_spec.hashCode, 和pig_spec.get().hashCode,还有sheep_spec.get().hashCode;
//      通过打印，我们很清晰看到出区别pig_spec.hashCode一只不变，有点类似普通@Inject。这是因为我们开始用@Injecy标注，
//      他帮我们调用了一次get()。而且用成员变量引用。但每次调用get()，都会生成新的实例。
//          而Lazy调用get()是一直不变的。这已经很说明他们之间的区别了
//
//这里我只是带新手入门，想要深入的只能靠自己了！！

public class LstudyActivity extends BaseActivity {
    //使用@Inject正常的。
    @Inject
    Cat cat_1;
    @Inject
    Cat cat_2;

    //使用Provider
    @Inject
    Provider<Pig> pig_1;
    @Inject
    Provider<Pig> pig_2;

    //使用Lazy
    @Inject
    Lazy<Sheep> sheep_1;
    @Inject
    Lazy<Sheep> sheep_2;


    //Provider、Lazy 和 @Inject的具体区别

    @Inject
    Provider<Pig> pig_spec;
    @Inject
    Lazy<Sheep> sheep_spec;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_l);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_l;
    }

    @Override
    protected void processLogic() {
        DaggerAnimComponent.builder().build().inject(this);
        LogUtils.i("看看hashCode值", "@Inject cat_1的hashCode ==> " + cat_1.hashCode());
        LogUtils.i("看看hashCode值", "@Inject cat_2的hashCode ==> " + cat_2.hashCode());
        LogUtils.i("看看hashCode值", "Provider pig_1的hashCode ==> " + pig_1.hashCode());
        LogUtils.i("看看hashCode值", "Provider pig_2的hashCode ==> " + pig_2.hashCode());
        LogUtils.i("看看hashCode值", "Lazy sheep_1的hashCode ==> " + sheep_1.hashCode());
        LogUtils.i("看看hashCode值", "Lazy sheep_2的hashCode ==> " + sheep_2.hashCode());
    }

    @OnClick(R.id.btn)
    public void specOnClick() {
        LogUtils.i("看看hashCode值", "Provider pig_spec不通过get的hashCode ==> " + pig_spec.hashCode());
        LogUtils.i("看看hashCode值", "Provider pig_spec的hashCode ==> " + pig_spec.get().hashCode());
        LogUtils.i("看看hashCode值", "Lazy sheep_spec的hashCode ==> " + sheep_spec.get().hashCode());
    }
}
