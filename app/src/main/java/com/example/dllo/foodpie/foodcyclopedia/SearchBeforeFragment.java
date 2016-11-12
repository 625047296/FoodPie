package com.example.dllo.foodpie.foodcyclopedia;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.SearchTogether;
import com.example.dllo.foodpie.goeat.first.OnClickItemListener;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchBeforeFragment extends BaseFragment implements OnClickItemListener {

    private RecyclerView rvBefore;
    private List<String> keywords;
    private SearchBeforeAdapter beforeAdapter;

    @Override
    protected int getLayout() {
        return  R.layout.fragment_search_before;
    }
    @Override
    protected void initView() {
        rvBefore = bindView(R.id.rv_search_before);
        beforeAdapter = new SearchBeforeAdapter();
        initGsonSearchBefore();

        beforeAdapter.setOnClickItemListener(this);

    }

    private void initGsonSearchBefore() {
        GsonRequest<SearchTogether> gson = new GsonRequest<SearchTogether>(SearchTogether.class,
                UrlNet.FoodSearchBeafore, new Response.Listener<SearchTogether>() {
            @Override
            public void onResponse(SearchTogether response) {

                keywords = response.getKeywords();
                beforeAdapter.setKeywords(keywords);
                rvBefore.setAdapter( beforeAdapter);

                GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                rvBefore.setLayoutManager(manager);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SearchBeforeFragment", "失败");
            }
        });
        VolleySingletion.getInstance().addRequest(gson);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(String Image, String name, String headIcon, String Like_ct) {

    }
//在fragment传递数据到activity
    @Override
    public void onPictureClick(String link) {


        FoodSearchActivity foodSearchActivity = (FoodSearchActivity) getActivity();
        foodSearchActivity.setKey(link);
      }
}
