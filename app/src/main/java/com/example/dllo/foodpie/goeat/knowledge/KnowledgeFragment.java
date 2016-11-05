package com.example.dllo.foodpie.goeat.knowledge;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.KnowledgeBean;
import com.example.dllo.foodpie.goeat.NetLineActivity;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public class KnowledgeFragment extends BaseFragment {

    private PullToRefreshListView lv;
    private KnowledgeAdapter knowledgeAdapter;
    private List<KnowledgeBean.FeedsBean> feeds;

    @Override
    protected int getLayout() {
        return R.layout.fragment_goeat_knowledge;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_knowledge_goeat);
        knowledgeAdapter = new KnowledgeAdapter(getContext());


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String urll = feeds.get(position).getLink();
                Intent intent =new Intent(getActivity(), NetLineActivity.class);
                intent.putExtra("Link",urll);
                startActivity(intent);
//                Uri uri = Uri.parse(url);
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
                initData();

            }
        });


    }

    @Override
    protected void initData() {

        GsonreQuest<KnowledgeBean> gsonreQuest = new GsonreQuest<KnowledgeBean>(KnowledgeBean.class,UrlNet.KnowledgeUrl ,
                new Response.Listener<KnowledgeBean>() {
                    @Override
                    public void onResponse(KnowledgeBean response) {
                        feeds = response.getFeeds();

                        knowledgeAdapter.setArrayList(feeds);
                        lv.setAdapter(knowledgeAdapter);
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
