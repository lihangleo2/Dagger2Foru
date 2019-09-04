package com.lihang.dagger2stu.study.jstudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.study.istudy.Dog;
import com.lihang.dagger2stu.study.jstudy.custom.DaggerDogOtherComponent;
import com.lihang.dagger2stu.study.jstudy.custom.MyOtherQualifier;
import com.lihang.dagger2stu.study.jstudy.custom.MyQualifier;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;
import butterknife.OnClick;

/**
 * Created by leo
 * on 2019/9/3.
 */
//1、这里我自定义@Qualifier：MyQualifier时，用了string value 之后，可以看到其作用和@Named作用一毛一样，
//   由此可知，@Named是@Qualifier的一种
//2、我们也可以之定义不带任何的MyOtherQualifier。
//3、同时这个限定符还能直接用来初始化数据


public class JstudyActivity extends BaseActivity {
    @Inject
    @MyQualifier("tag_1")
    Dog dog1;
    @Inject
    @MyQualifier("tag_5")
    Dog dog2;

    @MyOtherQualifier
    Dog dog3;

    @Override
    public String getActivityTitle() {
        return null;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_i;
    }

    @Override
    protected void processLogic() {
        DaggerDogOtherComponent.create().inject(this);
    }

    @OnClick(R.id.btn_1)
    public void prten() {
        ToastUtils.showToast(dog1.getType());
    }

    @OnClick(R.id.btn_2)
    public void prtenOther() {
        ToastUtils.showToast(dog2.getType() + "   &   " + dog3.getType());
    }
}
