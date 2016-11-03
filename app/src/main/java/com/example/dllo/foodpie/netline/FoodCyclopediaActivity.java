package com.example.dllo.foodpie.netline;

import android.widget.Adapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.List;

/**
 * Created by dllo on 16/11/3.
 */
public class FoodCyclopediaActivity extends BaseActivity {


    private FoodCyclopediaActivityAdapter adapter;
    private List<FoodCyclopediaBean.FoodsBean> foods;
    private ListView lv;

    @Override
    protected int getLayout() {
        return R.layout.activity_foodcyclopedia;

    }

    @Override
    protected void initView() {
        adapter =
                new FoodCyclopediaActivityAdapter(this);
        lv = bindView(R.id.lv_foodcyclopedia);


    }

    @Override
    protected void initData() {
        GsonreQuest<FoodCyclopediaBean> gsonreQuest = new GsonreQuest<FoodCyclopediaBean>(FoodCyclopediaBean.class,
                UrlNet.FoodCyclopediaurlActivity, new Response.Listener<FoodCyclopediaBean>() {
            @Override
            public void onResponse(FoodCyclopediaBean response) {
                foods = response.getFoods();
                adapter.setFoodsBeanList(foods);
                lv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gsonreQuest);

    }
}
