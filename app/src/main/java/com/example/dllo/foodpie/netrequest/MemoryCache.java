package com.example.dllo.foodpie.netrequest;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dllo on 16/10/25.
 */
public class MemoryCache implements ImageLoader.ImageCache {

    private LruCache<String,Bitmap> mCache;

    public MemoryCache() {
        int maxSize = (int) Runtime.getRuntime().maxMemory();
        mCache = new LruCache<String, Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };

    }

    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
    mCache.put(url,bitmap);
    }
}
