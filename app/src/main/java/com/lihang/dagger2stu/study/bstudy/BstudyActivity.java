package com.lihang.dagger2stu.study.bstudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by leo
 * on 2019/8/29.
 */
//1。假设Human不可随意更改,没有@Inject标注(第三方类库，不是你项目里的代码肯定没有@Inject)
//   用@module标注BstudyActivityModule，用@Provides标注方法的返回值就是我们需要inject的类型
//2、编写Component接口使用@Component标注这个接口，并使用modules=的方法链接上第一步中编写的Module类；
//3、接下来就和AstudyActivity中的使用方式一样了

public class BstudyActivity extends BaseActivity {
    @Inject
    Human human;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_b);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_astudy;
    }

    @Override
    protected void processLogic() {
        DaggerBstudyActivityComponent.create().injectTo(this);
        //
        ToastUtils.showToast(human.hashCode() + "");
    }

}
