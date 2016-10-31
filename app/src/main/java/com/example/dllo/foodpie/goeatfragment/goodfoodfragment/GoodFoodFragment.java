package com.example.dllo.foodpie.goeatfragment.goodfoodfragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GoodFoodFragment extends BaseFragment  {
    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=4&per=10";
    private ArrayList<GoodFoodTextBean> array;
    private GoodFoodAdapter adapter;
    private ListView lv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_goeat_goodfood ;
    }

    @Override
    protected void initView() {
        lv = BindView(R.id.lv_goodfood_goeat);
        array = new ArrayList<>();
        adapter = new GoodFoodAdapter(getContext());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ss = array.get(position).getLink();
                Uri uri = Uri.parse(ss);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void initDate() {

        Gsonrequest<GoodFoodBean> gsonrequest = new Gsonrequest<GoodFoodBean>(GoodFoodBean.class, url,
                new Response.Listener<GoodFoodBean>() {
                    @Override
                    public void onResponse(GoodFoodBean response) {
                        for (int i = 0; i < response.getFeeds().size(); i++) {
                            GoodFoodTextBean bean = new GoodFoodTextBean();

                            bean.setContent_type(response.getFeeds().get(i).getContent_type());

                            bean.setTitle(response.getFeeds().get(i).getTitle());
                            bean.setTail(response.getFeeds().get(i).getTail());
                            bean.setSource(response.getFeeds().get(i).getSource());
                            bean.setImages(response.getFeeds().get(i).getImages());
                            bean.setLink(response.getFeeds().get(i).getLink());
                            array.add(bean);

                        }
                        adapter.setArrayList(array);
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingletion.getInstance().addRequest(gsonrequest);

    }



}
