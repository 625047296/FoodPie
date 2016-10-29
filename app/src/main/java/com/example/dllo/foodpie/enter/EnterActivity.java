package com.example.dllo.foodpie.enter;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/10/29.
 */
public class EnterActivity extends BaseActivity implements View.OnClickListener {


    private Button btnBack;

    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initView() {
        btnBack = bindView(R.id.btn_enter_back);
        setClick(this, btnBack);

    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enter_back:
                onBackPressed();
                break;
        }
    }
}
