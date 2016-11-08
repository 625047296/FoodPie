package com.example.dllo.foodpie.goeat.first;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FirstBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;


/**
 * Created by dllo on 16/10/21.
 */
public class FirstFragment extends BaseFragment implements OnClickItemListener {
    private RecyclerView rv;
    private GoEatFirstAdapter goEatFirstAdapter;
    private GridLayoutManager manager;
    private SwipeRefreshLayout refreshLayout;



    @Override
    protected int getLayout() {

        return R.layout.fragment_goeat_first;
    }

    @Override
    protected void initView() {
        rv = bindView(R.id.rv_first_goeat);
        goEatFirstAdapter = new GoEatFirstAdapter(getContext());
        refreshLayout = bindView(R.id.refresh_first_goeat);
        goEatFirstAdapter.setOnClickItemListener(FirstFragment.this);
        //刷新
//       rv.addOnScrollListener(new EndLessOnScrollListener(manager) {
//           @Override
//           protected void onLoadMore(int curentPage) {
//
//
//           }
//       });
//      refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//          @Override
//          public void onRefresh() {
//              initData();
//          }
//      });
//
//
    }


    @Override
    protected void initData() {


        GsonRequest<FirstBean> gsonRequest = new GsonRequest<FirstBean>(FirstBean.class, UrlNet.FirstUrl,
                new Response.Listener<FirstBean>() {


                    @Override
                    public void onResponse(FirstBean response) {

                        goEatFirstAdapter.setFirstBean(response);
                        rv.setAdapter(goEatFirstAdapter);
                        Log.d("FirstFragment", "response:" + response);

                        manager = new GridLayoutManager(getContext(), 2);
                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                        rv.setLayoutManager(manager);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingletion.getInstance().addRequest(gsonRequest);
    }



    @Override
    public void onClick(String Image, String name, String headIcon, String Like_ct) {
        Intent intent = new Intent(getActivity(), PictureActivity.class);

        intent.putExtra("image", Image);
        intent.putExtra("name", name);
        intent.putExtra("headIcon", headIcon);
        intent.putExtra("Like_ct", Like_ct);
        startActivity(intent);
    }

    @Override
    public void onPictureClick(String position) {

        Intent intent = new Intent(getActivity(), PictureADActivity.class);
       intent.putExtra("Link", position) ;

        startActivity(intent);
    }
}
