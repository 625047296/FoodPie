package com.example.dllo.foodpie.MyActivity.info.foodcyclopedia;

import android.widget.GridView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netrequest.MyApp;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopedia_Fragment extends BaseFragment {



    @Override
    protected int getLayout() {
        return R.layout.item_foodfragment;
    }

    @Override
    protected void initView() {


        FoodAdapter foodAdapter = new FoodAdapter();




    }

    @Override
    protected void initDate() {

    }
}
