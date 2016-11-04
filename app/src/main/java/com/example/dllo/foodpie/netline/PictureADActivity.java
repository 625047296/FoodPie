package com.example.dllo.foodpie.netline;

import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureADActivity  extends BaseActivity implements View.OnClickListener {

    private WebView webView;
    private String url;
    private Button btnBack;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat_first_picture_ad;
    }

    @Override
    protected void initView() {
        webView =
                bindView(R.id.webview_goeat_first_picture_ad);
        btnBack =
                (Button) findViewById(R.id.btn_goeat_first_picture_ad);
        setClick(this,btnBack);
        //接收上一级传过来的link
        //注意是getIntent
        Intent intent = getIntent();
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

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
