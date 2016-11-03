package com.example.dllo.foodpie.goeat.appraisalfragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.AppraisaBean;
import com.example.dllo.foodpie.netline.NetLineActivity;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by dllo on 16/10/21.
 * 测评界面
 */
public class AppraisalFragment extends BaseFragment {

    private PullToRefreshListView lv;
    private AppraisalAdapter appraisalAdapter;
    private List<AppraisaBean.FeedsBean> feeds;

    @Override
    protected int getLayout() {
        return R.layout.frament_goeat_appraisal;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.iv_appraisa);
        appraisalAdapter = new AppraisalAdapter(getContext());


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String net = feeds.get(position).getLink();
                Intent intent = new Intent(getActivity(), NetLineActivity.class);
                intent.putExtra("Link",net);
                startActivity(intent);
//                Uri uri = Uri.parse(net);
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
            }
        });

        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {

                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {

                UrlNet.Page++;
                Log.d("AppraisalFragment", "UrlNet.Page++:" + UrlNet.Page++);

                initData();



            }
        });


    }

    @Override
    protected void initData() {

        GsonreQuest<AppraisaBean> gsonreQuest = new GsonreQuest<AppraisaBean>(AppraisaBean.class, UrlNet.AppraisalUrl,
                new Response.Listener<AppraisaBean>() {
                    @Override
                    public void onResponse(AppraisaBean response) {
                        feeds = response.getFeeds();
                        appraisalAdapter.setAppraisalTextBeen(feeds);
                        lv.setAdapter(appraisalAdapter);
                        lv.onRefreshComplete();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingletion.getInstance().addRequest(gsonreQuest);


    }
}
