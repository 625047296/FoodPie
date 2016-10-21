package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.My.MyFragment;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.goeat.goeatfragment.GoeatFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private Button food;
    private Button goeat;
    private Button my;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        food = bindView(R.id.btn_foodcyclopedia);
        goeat = bindView(R.id.btn_goeat);
        my = bindView(R.id.btn_my);

        setClick(this,food);
        setClick(this,goeat);
        setClick(this,my);


    }

    @Override
    protected void initDate() {


    }


    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_foodcyclopedia:
               break;
           case R.id.btn_goeat:

               Intent intent = new Intent(this, GoeatFragment.class);

               startActivity(intent);
               break;
           case R.id.btn_my:
//               Intent intent1 = new Intent(this, MyFragment.class);
               break;
       }

    }
}
