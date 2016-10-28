package com.example.dllo.foodpie.netrequest;

import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.dllo.foodpie.R;

/**
 * Created by dllo on 16/10/25.
 */
public class VolleySingletion {

    private static VolleySingletion mVolleySingletion;
   private    RequestQueue requestQueue;
   private ImageLoader imageLoader;


    private VolleySingletion() {

        requestQueue = Volley.newRequestQueue(MyApp.getContext());
      imageLoader = new ImageLoader(requestQueue,new MemoryCache());
    }

   public static VolleySingletion getInstance(){



       if (mVolleySingletion == null) {
           synchronized (VolleySingletion.class) {
               if (mVolleySingletion == null) {
                   mVolleySingletion = new VolleySingletion();
               }
           }
       }
       return mVolleySingletion;
   }
    public  void getImage(String url , ImageView image){
        imageLoader.get(url,ImageLoader.getImageListener(image, R.mipmap.diao,R.mipmap.diao ));

    }
    public <T> void addRequest(Request<T> request){
        requestQueue.add(request);
    }



}
