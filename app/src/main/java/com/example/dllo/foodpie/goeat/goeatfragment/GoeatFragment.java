package com.example.dllo.foodpie.goeat.goeatfragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.My.MyFragment;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.foodcyclopedia.MainActivity;
import com.example.dllo.foodpie.goeat.appraisalfragment.AppraisalFragment;
import com.example.dllo.foodpie.goeat.firstfragment.FirstFragment;
import com.example.dllo.foodpie.goeat.goodfoodfragment.GoodFoodFragment;
import com.example.dllo.foodpie.goeat.knowledgeframent.KnowlegeFrament;

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

        foodcyclopedia = BindView(R.id.btn_foodcyclopedia_goeat);
        goeat = BindView(R.id.btn_goeat_goeat);
        my = BindView(R.id.btn_my_goeat);
        setClick(this, foodcyclopedia);
        setClick(this,goeat);
        setClick(this,my);

        ArrayList<Fragment> fragments = new ArrayList<>();
        goeatAdapter = new GoeatAdapter(getFragmentManager());
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
            case R.id.btn_foodcyclopedia_goeat:
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_goeat_goeat:
                break;
            case R.id.btn_my_goeat:
                Intent intent1 = new Intent(getContext(),MyFragment.class);
                startActivity(intent1);
                break;
        }
    }

}