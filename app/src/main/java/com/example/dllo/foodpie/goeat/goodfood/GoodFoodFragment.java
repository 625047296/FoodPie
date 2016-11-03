package com.example.dllo.foodpie.goeat.goodfood;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.GoodFoodBean;
import com.example.dllo.foodpie.netline.NetLineActivity;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class GoodFoodFragment extends BaseFragment {

    private GoodFoodAdapter adapter;
    private PullToRefreshListView lv;
    private List<GoodFoodBean.FeedsBean> feeds;

    @Override
    protected int getLayout() {
        return R.layout.fragment_goeat_goodfood;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_goodfood_goeat);

        adapter = new GoodFoodAdapter(getContext());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String NetUrl = feeds.get(position).getLink();

//                Uri uri = Uri.parse(ss);
                Intent intent = new Intent(getActivity(), NetLineActivity.class);
                intent.putExtra("Link", NetUrl);
                startActivity(intent);

                //直接在app中打开webview
//                WebView webView = new WebView(getActivity());
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.setWebViewClient(new WebViewClient());
//                webView.loadUrl(ss);
//                getActivity().setContentView(webView);


//                Intent intent = new Intent(getActivity(), NetLineActivity.class);
//                startActivity(intent);
            }
        });
        //刷新加载
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {


            }
        });

    }

    @Override
    protected void initData() {

        GsonreQuest<GoodFoodBean> gsonreQuest = new GsonreQuest<GoodFoodBean>(GoodFoodBean.class, UrlNet.GoodFoodUrl,
                new Response.Listener<GoodFoodBean>() {


                    @Override
                    public void onResponse(GoodFoodBean response) {

                        feeds = response.getFeeds();

                        adapter.setArrayList(feeds);
                        lv.setAdapter(adapter);
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
