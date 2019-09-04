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

//具体介绍请到博客：https://juejin.im/post/5d6f81b8e51d4561f17a5136
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
