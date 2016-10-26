package com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.SingleSimpleThreadPool;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.MyApp;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dllo on 16/10/21.
 */
public class First_Fragment extends BaseFragment{
    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    private RecyclerView rv;
    private GoeatFirst_Adapter goeatFirstAdapter;
    private ArrayList<FirstBean.FeedsBean> arrayList;

    @Override
    protected int getLayout() {

       return R.layout.item_first;
    }

    @Override
    protected void initView() {

        rv = BindView(R.id.rv_first_goeat);

        arrayList = new ArrayList<>();
        goeatFirstAdapter = new GoeatFirst_Adapter();

//        goeatFirstAdapter.setArrayList(arrayList);
//        rv.setAdapter(goeatFirstAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(MyApp.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);


    }



    @Override
    protected void initDate() {

        Gsonrequest<FirstBean> gsonrequest = new Gsonrequest<FirstBean>(FirstBean.class, url,
                new Response.Listener<FirstBean>() {
                    @Override
                    public void onResponse(FirstBean response) {

                goeatFirstAdapter = new GoeatFirst_Adapter();

                 goeatFirstAdapter.setArrayList(arrayList);
                 rv.setAdapter(goeatFirstAdapter);




                        Log.d("FirstRunable", "来啊 ");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }  );



        VolleySingletion.getInstance().addRequest(gsonrequest);
//     VolleySingletion.getInstance().getImage(url,iv);


    }
   
}
