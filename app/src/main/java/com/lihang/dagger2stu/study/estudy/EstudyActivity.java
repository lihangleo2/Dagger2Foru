package com.lihang.dagger2stu.study.estudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.study.cstudy.Woman;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by leo
 * on 2019/9/3.
 */
//这里有变化的是：Module & Component
//在使用Builder的时候，经常可以看到有使用标注@BindsInstance
//这句我理解的是，我们之前是通过new Module进行赋值，本来Dagger2就是利器，这样怎么能忍、
//看我们的EstudyModule里的代码，我们去掉了构造方法，并且在方法里加上了int money参数。
//意思@BindsInstance可以帮我们省去写类的构造方法，而直接去赋值,同时最后一步就是改Component里Builder返回方法里的参数类型。
public class EstudyActivity extends BaseActivity {
    @Inject
    Woman woman;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_e);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_astudy;
    }

    @Override
    protected void processLogic() {
        DaggerEstudyActivityComponent.builder().initMoney(100).build().injectTo(this);
        ToastUtils.showToast(woman.getSoul().getMoney() + "");
    }
}
