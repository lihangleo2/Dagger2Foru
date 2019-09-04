package com.lihang.dagger2stu.study.mforandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.utils.ToastUtils;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by leo
 * on 2019/9/4.
 */
//之前介绍的知识，是在Java里的使用。而且你要在Android中使用，也必须了解。
//如果按之前的方式在Android中开发，简直要累死人，强大的google出了dagger.android扩展包。依赖相关依赖
//步骤：
//     1、首先创建NeedInjectModules，记得是抽象类。然后用@ContributesAndroidInjector标注方法，方法返回值是你要注入的目标区域。
//        要注入多个Activity的话，一直在这里加就好了
//     2、这里大概的意思是build一个AppComponent,然后其他类的Component都会依赖它。只不过框架已经帮我们实现。所以整个项目只有一个
//        AppComponent。
//     3、创建我们唯一的AppComponent，一个是系统的module:AndroidSupportInjectionModule,必须加上，然后一个是我们注册的moduleNeedInjectModules;
//        然后AppComponent继承AndroidInjector<T>，泛型是我们AppComponent需要build的地方，接下来使用@Component.Builder。不懂的看前面
//     4、这些好了后，用我们的MyApplication继承DaggerApplication，后实现applicationInjector方法，把我们的AppComponent build下。
//     5、假如我们的ForAndoriActivity里需要用到AndroidBean(这里就不讲module了，其实都一样)。只需将我们的ForAndoriActivity
//        继承我们的DaggerAppCompatActivity，当然Fragment需要用也只需要继承DaggerFragment。然后在NeedInjectModules加一下就好了
//     6、完成了这些，就能在Android中使用了！！！舒服
//特别说明：如果还要加Module，只需要在AppComponent上加上就是了。如果需要注册到多个地方只需要用 @ContributesAndroidInjector标注下
//          然后写上返回值加到NeedInjectModules上即可。还有怎么在MVP中使用呢，看下一篇

public class ForAndroidActivity extends DaggerAppCompatActivity {
    @Inject
    AndroidBean androidBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astudy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.dagger2_for_android));
        ToastUtils.showToast(androidBean.hashCode() + "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
