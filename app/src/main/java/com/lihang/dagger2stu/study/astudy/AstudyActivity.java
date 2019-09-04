package com.lihang.dagger2stu.study.astudy;

import android.widget.Toast;


import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by leo
 * on 2019/8/29.
 */
//第一步：用Inject标注，告诉dagger2可以实例化这个类,如：Person
//第二步：使用注解Component,表示要将依赖注入到AstudyActivity里
//第三步：使用android studio build下的Make Project生成代码，使他自动生成DaggerComponent生成的类，类名是：Dagge+我们定义的Component的名字
public class AstudyActivity extends BaseActivity {
    @Inject
    Person person;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_a);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_astudy;
    }

    @Override
    protected void processLogic() {
        //第一种
        DaggerAstudyActivityComponent.create().injectTo(this);
        //第二种
//        DaggerAstudyActivityComponent.builder().build().injectTo(this);
        //
        Toast.makeText(AstudyActivity.this, person.toString() + "  ===  " + person.hashCode(), Toast.LENGTH_SHORT).show();
    }
}
