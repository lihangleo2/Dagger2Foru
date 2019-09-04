package com.lihang.dagger2stu.study.fstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseFragment;
import com.lihang.dagger2stu.study.bstudy.Human;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by leo
 * on 2019/9/3.
 */
public class TestFragment extends BaseFragment {
    @Inject
    Human human;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        FstudyActivityComponent fstudyActivityComponent = ((FstudyActivity) getActivity()).getFstudyActivityComponent();
        DaggerTestFragmentComponent.builder()
                .fstudyActivityComponent(fstudyActivityComponent)
                .build().inject(this);
        ToastUtils.showToast(human.hashCode() + "");
    }

}
