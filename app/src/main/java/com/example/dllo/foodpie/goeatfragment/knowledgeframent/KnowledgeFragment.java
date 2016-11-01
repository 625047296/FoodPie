package com.example.dllo.foodpie.goeatfragment.knowledgeframent;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netline.NetLineActivity;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public class KnowledgeFragment extends BaseFragment {

    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10";
    private ListView lv;
    private KnowledgeAdapter knowledgeAdapter;
    private ArrayList<KnowledgeTextBean> bean ;

    @Override
    protected int getLayout() {
        return R.layout.fragment_goeat_knowledge;
    }

    @Override
    protected void initView() {
        lv = BindView(R.id.lv_knowledge_goeat);
        knowledgeAdapter = new KnowledgeAdapter(getContext());
        bean = new ArrayList<>();
        knowledgeAdapter.setArrayList(bean);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = bean.get(position).getLink();
                Intent intent =new Intent(getActivity(), NetLineActivity.class);
                intent.putExtra("Link",url);
                startActivity(intent);
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void initDate() {

        Gsonrequest<KnowledgeBean> gsonrequest = new Gsonrequest<KnowledgeBean>(KnowledgeBean.class, url,
                new Response.Listener<KnowledgeBean>() {
                    @Override
                    public void onResponse(KnowledgeBean response) {
                        for (int i = 0; i < response.getFeeds().size(); i++) {
                           KnowledgeTextBean beans = new KnowledgeTextBean();
                            beans.setTitle(response.getFeeds().get(i).getTitle());
                            beans.setSource(response.getFeeds().get(i).getSource());
                            beans.setTail(response.getFeeds().get(i).getTail());
                            beans.setLink(response.getFeeds().get(i).getLink());



                           beans.setImages(response.getFeeds().get(i).getImages().get(0));
                            bean.add(beans);
                         //   Log.d("KnowledgeFragment", "response:" + response);
                        }
                        knowledgeAdapter.setArrayList(bean);
                        lv.setAdapter(knowledgeAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gsonrequest);

    }
}
