package com.example.dllo.foodpie.My;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.foodcyclopedia.MainActivity;
import com.example.dllo.foodpie.goeat.goeatfragment.GoeatFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected int getLayout() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {
        Button foodcyclopedia = BindView(R.id.btn_foodcyclopedia_my);
        Button goeat = BindView(R.id.btn_goeat_my);
        Button my = BindView(R.id.btn_my_my);
        setClick(this,foodcyclopedia);
        setClick(this,goeat);
        setClick(this,my);

    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_foodcyclopedia_my:
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_goeat_my:
                Intent intent1 = new Intent(getContext(), GoeatFragment.class);
                startActivity(intent1);
                break;
            case R.id.btn_my_my:
                break;
        }

    }
}
