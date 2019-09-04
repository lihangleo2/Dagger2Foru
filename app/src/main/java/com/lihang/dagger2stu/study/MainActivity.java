package com.lihang.dagger2stu.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.lihang.dagger2stu.R;
import com.lihang.dagger2stu.study.astudy.AstudyActivity;
import com.lihang.dagger2stu.adapter.MainAdapter;
import com.lihang.dagger2stu.bean.MainBean;
import com.lihang.dagger2stu.study.bstudy.BstudyActivity;
import com.lihang.dagger2stu.study.cstudy.CstudyActivity;
import com.lihang.dagger2stu.study.dstudy.DstudyActivity;
import com.lihang.dagger2stu.study.estudy.EstudyActivity;
import com.lihang.dagger2stu.study.fstudy.FstudyActivity;
import com.lihang.dagger2stu.study.gstudy.GstudyActivity;
import com.lihang.dagger2stu.study.hstudy.HstudyActivity;
import com.lihang.dagger2stu.study.istudy.IstudyActivity;
import com.lihang.dagger2stu.study.jstudy.JstudyActivity;
import com.lihang.dagger2stu.study.kstudy.KstudyActivity;
import com.lihang.dagger2stu.study.lstudy.LstudyActivity;
import com.lihang.dagger2stu.study.mforandroid.ForAndroidActivity;
import com.lihang.nbadapter.BaseAdapter;

import java.util.ArrayList;

/**
 * 本文学习链接：https://www.jianshu.com/p/22c397354997
 */

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private ArrayList<MainBean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MainAdapter();
        setOnItemClick();
        adapter.setDataList(dataList);
        recyclerView.setAdapter(adapter);
    }

    private void setOnItemClick() {
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener<MainBean>() {
            @Override
            public void onItemClick(MainBean item, int position) {
                switch (position) {
                    case 0:
                        transfer(AstudyActivity.class);
                        break;
                    case 1:
                        transfer(BstudyActivity.class);
                        break;
                    case 2:
                        transfer(CstudyActivity.class);
                        break;
                    case 3:
                        transfer(DstudyActivity.class);
                        break;
                    case 4:
                        transfer(EstudyActivity.class);
                        break;
                    case 5:
                        transfer(FstudyActivity.class);
                        break;
                    case 6:
                        transfer(GstudyActivity.class);
                        break;
                    case 7:
                        transfer(HstudyActivity.class);
                        break;
                    case 8:
                        transfer(IstudyActivity.class);
                        break;
                    case 9:
                        transfer(JstudyActivity.class);
                        break;
                    case 10:
                        transfer(KstudyActivity.class);
                        break;
                    case 11:
                        transfer(LstudyActivity.class);
                        break;
                    case 12:
                        transfer(ForAndroidActivity.class);
                        break;


                }
            }
        });
    }

    private void addData() {
        dataList.add(new MainBean(getString(R.string.dagger2_a), getString(R.string.dagger2_a_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_b), getString(R.string.dagger2_b_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_c), getString(R.string.dagger2_c_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_d), getString(R.string.dagger2_d_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_e), getString(R.string.dagger2_e_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_f), getString(R.string.dagger2_f_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_g), getString(R.string.dagger2_g_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_h), getString(R.string.dagger2_h_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_i), getString(R.string.dagger2_i_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_j), getString(R.string.dagger2_j_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_k), getString(R.string.dagger2_k_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_l), getString(R.string.dagger2_l_des)));
        dataList.add(new MainBean(getString(R.string.dagger2_for_android), getString(R.string.dagger2_for_android_des)));
    }


    public void transfer(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
