package com.example.dllo.foodpie;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.MyActivity.foodcyclopedia.My.MyFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.foodcyclopedia.FoodCyclopediaFragment;
import com.example.dllo.foodpie.MyActivity.foodcyclopedia.goeat.goeatfragment.GoeatFragment;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button food;
    private Button goeat;
    private Button my;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    boolean isselected = false;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        food = bindView(R.id.btn_foodcyclopedia);
        goeat = bindView(R.id.btn_goeat);
        my = bindView(R.id.btn_my);

        FragmentManager  manager = getSupportFragmentManager();
        FragmentTransaction  transaction = manager.beginTransaction();
        transaction.replace(R.id.layout,new FoodCyclopediaFragment());
        transaction.commit();

        setClick(this,food);
        setClick(this,goeat);
        setClick(this,my);



    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (v.getId()){
           case R.id.btn_foodcyclopedia:
               transaction.replace(R.id.layout,new FoodCyclopediaFragment());
              food.setSelected(true);
               goeat.setSelected(false);
               my.setSelected(false);

               break;
           case R.id.btn_goeat:
               transaction.replace(R.id.layout,new GoeatFragment());
               food.setSelected(false);
               goeat.setSelected(true);
               my.setSelected(false);


               break;
           case R.id.btn_my:
               transaction.replace(R.id.layout,new MyFragment());
               food.setSelected(false);
               goeat.setSelected(false);
               my.setSelected(true);
               break;
       }
        transaction.commit();

    }
}
