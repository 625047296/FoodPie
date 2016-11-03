package com.example.dllo.foodpie.netline;

import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureADActivity  extends BaseActivity{

    private WebView webView;
    private String url;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat_first_picture_ad;
    }

    @Override
    protected void initView() {
        webView =
                bindView(R.id.webview_goeat_first_picture_ad);
        Intent intent = new Intent();
        url = intent.getStringExtra("Link");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                webView.loadUrl(url);
                return true;
            }
        });



    }

    @Override
    protected void initData() {

    }
}
