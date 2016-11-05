package com.example.dllo.foodpie.goeat;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/1.
 */
public class NetLineActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int getLayout() {
        return R.layout.activity_netline;
    }

    @Override
    protected void initView() {
        WebView webView = bindView(R.id.webview);
        Button back = bindView(R.id.btn_netline_back);

        Intent intent = getIntent();
        String url = intent.getStringExtra("Link");

        webView.loadUrl(url);

        setClick(this,back);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
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
