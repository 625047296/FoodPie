package com.example.dllo.foodpie.goeatfragment.firstfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
public class FirstFragment extends BaseFragment{
    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    private RecyclerView rv;
    private GoeatFirstAdapter goeatFirstAdapter;
    private ArrayList<FirstTextBean> arrayList;

    @Override
    protected int getLayout() {

       return R.layout.fragment_goeat_first;
    }

    @Override
    protected void initView() {

        rv = BindView(R.id.rv_first_goeat);

        arrayList = new ArrayList<>();
        goeatFirstAdapter = new GoeatFirstAdapter(getContext());





    }



    @Override
    protected void initDate() {



        Gsonrequest<FirstBean> gsonrequest = new Gsonrequest<FirstBean>(FirstBean.class, url,
                new Response.Listener<FirstBean>() {
                    @Override
                    public void onResponse(FirstBean response) {

                        for (int i = 0; i <response.getFeeds().size() ; i++) {
                            FirstTextBean firstbean = new FirstTextBean();
                            firstbean.setCard_image(response.getFeeds().get(i).getCard_image());
                            firstbean.setDescription(response.getFeeds().get(i).getDescription());
                            firstbean.setPublisher(response.getFeeds().get(i).getPublisher());
                            firstbean.setTitle(response.getFeeds().get(i).getTitle());
                            firstbean.setPublisher_avatar(response.getFeeds().get(i).getPublisher_avatar());
                            firstbean.setLikect(response.getFeeds().get(i).getLike_ct());
                            arrayList.add(firstbean);
                        }


                goeatFirstAdapter = new GoeatFirstAdapter(getContext());

                 goeatFirstAdapter.setArrayList(arrayList);

                 rv.setAdapter(goeatFirstAdapter);
                        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
                        manager.setOrientation(LinearLayoutManager.VERTICAL);

                        rv.setLayoutManager(manager);




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
