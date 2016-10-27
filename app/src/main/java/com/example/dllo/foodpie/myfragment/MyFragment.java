package com.example.dllo.foodpie.myfragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.mainactivity.MainActivity;
import com.example.dllo.foodpie.setactivity.SetActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private Button btn;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        LinearLayout photo = BindView(R.id.photo_my);
        LinearLayout order = BindView(R.id.order_my);
        LinearLayout upload = BindView(R.id.upload_my);
        LinearLayout collect = BindView(R.id.collect_my);
        btn = BindView(R.id.btn_my);
        setClick(this,btn);

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
            case R.id.btn_my:
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
                break;
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
