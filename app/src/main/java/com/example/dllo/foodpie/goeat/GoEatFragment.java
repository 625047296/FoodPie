package com.example.dllo.foodpie.goeat;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.goeat.appraisalfragment.AppraisalFragment;
import com.example.dllo.foodpie.goeat.first.FirstFragment;
import com.example.dllo.foodpie.goeat.goodfood.GoodFoodFragment;
import com.example.dllo.foodpie.goeat.knowledge.KnowledgeFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GoEatFragment extends BaseFragment implements View.OnClickListener {
    private Button foodcyclopedia;
    private Button goeat;
    private Button my;
    private TabLayout tb;
    private ViewPager vp;
    private GoEatAdapter goEatAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_goeat;

    }

    @Override
    protected void initView() {

    vp = bindView(R.id.vp_goeat);
        tb = bindView(R.id.tb_goeat);


        ArrayList<Fragment> fragments = new ArrayList<>();
        goEatAdapter = new GoEatAdapter(getChildFragmentManager());
        fragments.add(new FirstFragment());
        fragments.add(new AppraisalFragment());
        fragments.add(new KnowledgeFragment());
        fragments.add(new GoodFoodFragment());

        goEatAdapter.setFragments(fragments);
        vp.setAdapter(goEatAdapter);
        tb.setupWithViewPager(vp);
    }

    @Override
    protected void initData() {
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

}