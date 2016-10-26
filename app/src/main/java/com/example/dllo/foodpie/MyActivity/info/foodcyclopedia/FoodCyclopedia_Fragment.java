package com.example.dllo.foodpie.MyActivity.info.foodcyclopedia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.SingleSimpleThreadPool;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopedia_Fragment extends BaseFragment implements AdapterView.OnItemClickListener {
 private GridView gridview;


    @Override
    protected int getLayout() {
        return R.layout.item_foodfragment;
    }

    @Override
    protected void initView() {
 ArrayList<FoodBean> arrayList = new ArrayList<>();
       gridview = BindView(R.id.gv_food);
        GridView_Adapter gridViewAdapter = new GridView_Adapter();



        gridview.setAdapter(gridViewAdapter);
        gridViewAdapter.setArrayList(arrayList);
        gridview.setOnItemClickListener(this);


    }



    @Override
    protected void initDate() {

        SingleSimpleThreadPool singleSimpleThreadPool =  SingleSimpleThreadPool.getInStance();
        ThreadPoolExecutor executor = singleSimpleThreadPool.getThreadPoolExecutor();
        executor.execute(new FoodRunable());



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}
