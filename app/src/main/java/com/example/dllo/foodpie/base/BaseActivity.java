package com.example.dllo.foodpie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.bmob.v3.Bmob;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseActivity extends AppCompatActivity{
    //aaaa
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
    }
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();

    protected <T extends View> T bindView( int id){
        return (T) findViewById(id);
    }

    protected void setClick(View.OnClickListener onClickListener,View ...views ){
        for (View view :views){
        view.setOnClickListener(onClickListener);
    }
}



}
