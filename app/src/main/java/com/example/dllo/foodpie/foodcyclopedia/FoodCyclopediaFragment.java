package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.util.Log;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopediaFragment extends BaseFragment implements OnClick {

    private FoodCyclopediaAdapter foodCyclopediaAdapterFirst, foodCyclopediaAdapterSecond, foodCyclopediaAdapterThird;
    private GridView gridViewSecond;
    private GridView gridViewThird;
    private GridView gridViewFirst;

    @Override
    protected int getLayout() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView() {
        gridViewFirst = bindView(R.id.gv_food);
        gridViewSecond = bindView(R.id.gvtwo_food);
        gridViewThird = bindView(R.id.gvthree_food);
        foodCyclopediaAdapterFirst = new FoodCyclopediaAdapter();
        foodCyclopediaAdapterSecond = new FoodCyclopediaAdapter();
        foodCyclopediaAdapterThird = new FoodCyclopediaAdapter();

    }

    @Override
    protected void initData() {

        initGridViewFirst();
        foodCyclopediaAdapterFirst.setOnClick(this);
        foodCyclopediaAdapterSecond.setOnClick(this);
        foodCyclopediaAdapterThird.setOnClick(this);

    }
    private void initGridViewFirst() {
        GsonRequest<FoodCyclopediaBean> gsonRequest = new GsonRequest<FoodCyclopediaBean>(FoodCyclopediaBean.class, UrlNet.FoodCyclopediaurl,
                new Response.Listener<FoodCyclopediaBean>() {
                    @Override
                    public void onResponse(FoodCyclopediaBean response) {

                        foodCyclopediaAdapterFirst.setFoodCyclopediaBean(0, response);
                        gridViewFirst.setAdapter(foodCyclopediaAdapterFirst);
                        foodCyclopediaAdapterSecond.setFoodCyclopediaBean(1, response);
                        gridViewSecond.setAdapter(foodCyclopediaAdapterSecond);
                        foodCyclopediaAdapterThird.setFoodCyclopediaBean(2, response);
                        gridViewThird.setAdapter(foodCyclopediaAdapterThird);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingletion.getInstance().addRequest(gsonRequest);

    }

    @Override
    public void onClickSms(String kind, int id, String name) {
        Intent intent = new Intent(getActivity(), FoodDescriptionActivity.class);

        intent.putExtra("kind", kind);
        intent.putExtra("idInfo", id);
        intent.putExtra("name",name);

        Log.d("FoodCyclopediaFragment0", "idInfo:" + id);
        Log.d("FoodCyclopediaFragment0", kind);
        startActivity(intent);
    }
}
