package com.lihang.dagger2stu.study.dstudy;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.base.BaseActivity;
import com.lihang.dagger2stu.study.cstudy.CstudyModule;
import com.lihang.dagger2stu.study.cstudy.Soul;
import com.lihang.dagger2stu.study.cstudy.Woman;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;

/**
 * Created by leo
 * on 2019/8/30.
 */
//这里有变化的是：Component里的代码
//通过我们cstudy的内容，你可以点开cstudyModule查看源码，可以看到有个Builder cstudyModule(CstudyModule cstudyModule){}。这是dagger2自动生成的
//(你还可以通过，app/build/generated/source/apt/debug/你的包名/DaggerAppComponent.java 目录下找到)
//由此我们来看看@Component.Builder的用法
//其他都不用变，要变的是Component,定义个Builder并用@Component.Builder标注。这里有2个方法：
//方法一：是返回值Builder的方法，这里如果传module就会以我们传的为主，否则他会帮我们生成一个money为0的module。当然你也随意传数据类型，只不过无效。可以试试，
//方法二：是返回值为当前Component的方法，方法名其实都可以自定义，当最好以规范为主，用习惯了就明白了

public class DstudyActivity extends BaseActivity {

    @Inject
    Woman dWoman;

    @Override
    public String getActivityTitle() {
        return getString(R.string.dagger2_d);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_astudy;
    }

    @Override
    protected void processLogic() {
        DaggerDstudyActivityComponent.builder().cstudyModule(new CstudyModule(100)).build().injectTo(this);
        ToastUtils.showToast(dWoman.getSoul().getMoney() + "");
    }
}
