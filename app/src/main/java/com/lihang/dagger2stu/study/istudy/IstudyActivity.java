package com.lihang.dagger2stu.study.istudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.OnClick;

/**
 * Created by leo
 * on 2019/9/3.
 */

public class IstudyActivity extends BaseActivity {
    @Inject
    @Named("tag_1")
    Dog dog1;
    @Inject
    @Named("tag_2")
    Dog dog2;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_i);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_i;
    }

    @Override
    protected void processLogic() {
        DaggerDogComponent.create().inject(this);
    }

    @OnClick(R.id.btn_1)
    public void prten() {
        ToastUtils.showToast(dog1.getType());
    }

    @OnClick(R.id.btn_2)
    public void prtenOther() {
        ToastUtils.showToast(dog2.getType());
    }
}
