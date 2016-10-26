package com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment.FirstRunable;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.appraisalfragment.Appraisal_Fragment;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment.First_Fragment;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.goodfoodfragment.GoodFood_Fragment;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.knowledgeframent.Knowlege_Frament;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dllo on 16/10/21.
 */
public class Goeat_Fragment extends BaseFragment implements View.OnClickListener {
    private Button foodcyclopedia;
    private Button goeat;
    private Button my;
    private TabLayout tb;
    private ViewPager vp;
    private Goeat_Adapter goeatAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat;

    }

    @Override
    protected void initView() {

    vp = BindView(R.id.vp_goeat);
        tb = BindView(R.id.tb_goeat);


        ArrayList<Fragment> fragments = new ArrayList<>();
        goeatAdapter = new Goeat_Adapter(getChildFragmentManager());
        fragments.add(new First_Fragment());
        fragments.add(new Appraisal_Fragment());
        fragments.add(new Knowlege_Frament());
        fragments.add(new GoodFood_Fragment());

        goeatAdapter.setFragments(fragments);
        vp.setAdapter(goeatAdapter);
        tb.setupWithViewPager(vp);

    }

    @Override
    protected void initDate() {

        SingleSimpleThreadPool singleSimpleThreadPool =  SingleSimpleThreadPool.getInStance();
        ThreadPoolExecutor executor = singleSimpleThreadPool.getThreadPoolExecutor();
        executor.execute(new FirstRunable());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}