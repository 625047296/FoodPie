package com.example.dllo.foodpie.MyActivity.info.My;

import android.view.View;
import android.widget.LinearLayout;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class My_Fragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected int getLayout() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {
        LinearLayout photo = BindView(R.id.photo_my);
        LinearLayout order = BindView(R.id.order_my);
        LinearLayout upload = BindView(R.id.upload_my);
        LinearLayout collect = BindView(R.id.collect_my);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.photo_my:
                break;
            case R.id.order_my:
                break;
            case R.id.collect_my:
                break;
            case R.id.upload_my:
                break;

        }

    }
}
