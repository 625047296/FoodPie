package com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment.appraisalfragment.AppraisalFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment.firstfragment.FirstFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment.goodfoodfragment.GoodFoodFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment.knowledgeframent.KnowlegeFrament;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GoeatFragment extends BaseFragment implements View.OnClickListener {
    private Button foodcyclopedia;
    private Button goeat;
    private Button my;
    private TabLayout tb;
    private ViewPager vp;
    private GoeatAdapter goeatAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat;

    }

    @Override
    protected void initView() {

    vp = BindView(R.id.vp_goeat);
        tb = BindView(R.id.tb_goeat);


        ArrayList<Fragment> fragments = new ArrayList<>();
        goeatAdapter = new GoeatAdapter(getChildFragmentManager());
        fragments.add(new FirstFragment());
        fragments.add(new AppraisalFragment());
        fragments.add(new KnowlegeFrament());
        fragments.add(new GoodFoodFragment());

        goeatAdapter.setFragments(fragments);
        vp.setAdapter(goeatAdapter);
        tb.setupWithViewPager(vp);

    }

    @Override
    protected void initDate() {



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}