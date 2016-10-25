package com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

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
    private GoeatFirstAdapter goeatFirstAdapter;
    private ArrayList<FirstBean.FeedsBean> arrayList;

    @Override
    protected int getLayout() {

       return R.layout.item_first;
    }

    @Override
    protected void initView() {

        rv = BindView(R.id.rv_first_goeat);

        arrayList = new ArrayList<>();
        goeatFirstAdapter = new GoeatFirstAdapter();

        goeatFirstAdapter.setArrayList(arrayList);
        rv.setAdapter(goeatFirstAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(MyApp.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

    }

//    Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//        }
//    };

    @Override
    protected void initDate() {

        SingleSimpleThreadPool singleSimpleThreadPool =  SingleSimpleThreadPool.getInStance();
        ThreadPoolExecutor executor = singleSimpleThreadPool.getThreadPoolExecutor();
        executor.execute(new FirstRunable());








    }
}
