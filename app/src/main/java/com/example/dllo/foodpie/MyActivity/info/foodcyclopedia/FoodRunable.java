package com.example.dllo.foodpie.MyActivity.info.foodcyclopedia;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment.FirstBean;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.MyApp;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dllo on 16/10/26.
 */
public class FoodRunable implements Runnable {
    String url = "http://food.boohee.com/fb/v1/categories/list";

    @Override
    public void run() {
//        Gsonrequest<FoodBean> gsonrequest = new Gsonrequest<FoodBean>(FoodBean.class, url,
//                new Response.Listener<FoodBean>() {
//                    @Override
//                    public void onResponse(FoodBean response) {
//
//                        Log.d("FoodRunable", "大哥");
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        VolleySingletion.getInstance().addRequest(gsonrequest);



    }
}
