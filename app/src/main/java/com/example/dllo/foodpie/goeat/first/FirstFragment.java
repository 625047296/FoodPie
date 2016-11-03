package com.example.dllo.foodpie.goeat.first;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FirstBean;
import com.example.dllo.foodpie.netline.PictureADActivity;
import com.example.dllo.foodpie.netline.PictureActivity;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.List;


/**
 * Created by dllo on 16/10/21.
 */
public class FirstFragment extends BaseFragment implements OnClickItemListener {
    private RecyclerView rv;
    private GoEatFirstAdapter goEatFirstAdapter;
    private List<FirstBean.FeedsBean> feeds;

    @Override
    protected int getLayout() {

        return R.layout.fragment_goeat_first;
    }

    @Override
    protected void initView() {
        rv = bindView(R.id.rv_first_goeat);
        goEatFirstAdapter = new GoEatFirstAdapter(getContext());
        goEatFirstAdapter.setOnClickItemListener(FirstFragment.this);
    }

    @Override
    protected void initData() {


        GsonreQuest<FirstBean> gsonreQuest = new GsonreQuest<FirstBean>(FirstBean.class, UrlNet.FirstUrl,
                new Response.Listener<FirstBean>() {
                    @Override
                    public void onResponse(FirstBean response) {
                        feeds = response.getFeeds();
                        goEatFirstAdapter.setArrayList(feeds);
                        rv.setAdapter(goEatFirstAdapter);

                        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv.setLayoutManager(manager);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingletion.getInstance().addRequest(gsonreQuest);
    }

    @Override
    public void onClick(int position) {
       String image = feeds.get(position).getCard_image();
        Intent intent = new Intent(getActivity(), PictureActivity.class);
        intent.putExtra("image",image);
        startActivity(intent);
    }

    @Override
    public void onPictureClick(int position) {

        Intent intent = new Intent(getActivity(), PictureADActivity.class);
       intent.putExtra("Link",feeds.get(position).getLink()) ;

        startActivity(intent);
    }
}
