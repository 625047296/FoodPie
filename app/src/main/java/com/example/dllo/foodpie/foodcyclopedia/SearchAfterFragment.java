package com.example.dllo.foodpie.foodcyclopedia;

import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.bean.FoodDescriptionPopAllBean;
import com.example.dllo.foodpie.bean.SearchBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.EventInfo;
import com.example.dllo.foodpie.tools.UrlNet;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchAfterFragment extends BaseFragment {
    private SearchAdapter searchAdapter;
    private String inPutUrl;
    private ListView lv_search;
    private List<SearchBean.ItemsBean> items;



    @Override
    protected int getLayout() {
        return R.layout.fragment_seach_info;
    }

    @Override
    protected void initView() {
        lv_search = bindView(R.id.lv_search_info);
        searchAdapter = new SearchAdapter();

        //注册EventBus
        EventBus.getDefault().register(this);

    }



    //要@Subscribe让Eventbus找到方法

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventInfo(EventInfo event) {


        inPutUrl = UrlNet.FoodSearch + event.getEditText();
        Log.d("SearchAfterFragment1", inPutUrl);

//     initGson();
        GsonRequest<SearchBean> gson = new GsonRequest<SearchBean>(SearchBean.class, inPutUrl,
                new Response.Listener<SearchBean>() {


                    @Override
                    public void onResponse(SearchBean response) {
                        items = response.getItems();
                        searchAdapter.setItems(items);
                        lv_search.setAdapter(searchAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gson);
//    private void initGson() {
//
//        Log.d("SearchAfterFragment1", inPutUrl);
//        GsonRequest<FoodDescriptionBean> gsonRequest = new GsonRequest<FoodDescriptionBean>(FoodDescriptionBean.class,
//                inPutUrl, new Response.Listener<FoodDescriptionBean>() {
//            @Override
//            public void onResponse(FoodDescriptionBean response) {
//
//                foods = response.getFoods();
//                Log.d("SearchAfterFragment", "ddd");
//
//                foodDescriptionActivityAdapter.setFoodsBeanList(foods);
//                lv_search.setAdapter(foodDescriptionActivityAdapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        VolleySingletion.getInstance().addRequest(gsonRequest);
//    }

    }

//销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initData() {

    }
}
