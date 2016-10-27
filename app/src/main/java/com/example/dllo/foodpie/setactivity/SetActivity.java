package com.example.dllo.foodpie.setactivity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

import java.util.AbstractCollection;


/**
 * Created by dllo on 16/10/26.
 */
public class SetActivity extends BaseActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected int getLayout() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
        btn = bindView(R.id.btn_setback);
        setClick(this, btn);


    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_setback:
                onBackPressed();
                break;
        }
    }
}
