package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchAfterFragment extends BaseFragment {
    private List<FoodDescriptionBean.FoodsBean> foods;
    private FoodDescriptionActivityAdapter foodDescriptionActivityAdapter;
    public static final int RESULT_CODE = 102;

    @Override
    protected int getLayout() {
        return R.layout.fragment_seach_info;
    }

    @Override
    protected void initView() {



        final ListView lv_search = bindView(R.id.lv_search_info);


        String inPut = UrlNet.FoodSearch + etSearch.getText().toString();
        GsonRequest<FoodDescriptionBean> gsonRequest = new GsonRequest<FoodDescriptionBean>(FoodDescriptionBean.class,
                inPut, new Response.Listener<FoodDescriptionBean>() {
            @Override
            public void onResponse(FoodDescriptionBean response) {
//             SearchAdapter searchAdapter = new SearchAdapter();
                foods = response.getFoods();
                foodDescriptionActivityAdapter = new FoodDescriptionActivityAdapter(getActivity());
                foodDescriptionActivityAdapter.setFoodsBeanList(foods);
                lv_search.setAdapter(foodDescriptionActivityAdapter);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        Intent intent = getIntent();
        intent.putExtra("bundle",bundle);
        setResult(RESULT_CODE,intent);
        finish();

    }


    @Override
    protected void initData() {

    }
}
