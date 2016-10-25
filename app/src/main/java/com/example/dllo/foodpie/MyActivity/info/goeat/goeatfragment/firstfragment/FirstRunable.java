package com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

/**
 * Created by dllo on 16/10/25.
 */
public class FirstRunable implements Runnable {
    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";

    @Override
    public void run() {
//       RequestQueue requestQueue
        //= Volley.newRequestQueue(this);
//                 = VolleySingletion.getInstance().addRequest();
//        View view = LayoutInflater.from(MyApp.getmContext()).inflate(R.layout.item_firstgoeata,null);
//        ImageView iv = (ImageView) view.findViewById(R.id.iv_first);
        Gsonrequest<FirstBean> gsonrequest = new Gsonrequest<FirstBean>(FirstBean.class, url,
                new Response.Listener<FirstBean>() {
                    @Override
                    public void onResponse(FirstBean response) {
                        Log.d("FirstRunable", "来啊 ");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }  );



        VolleySingletion.getInstance().addRequest(gsonrequest);
//      VolleySingletion.getInstance().getImage(url,iv);


    }
}
