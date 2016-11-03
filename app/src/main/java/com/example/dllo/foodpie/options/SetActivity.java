package com.example.dllo.foodpie.options;

import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;


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
    protected void initData() {

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
