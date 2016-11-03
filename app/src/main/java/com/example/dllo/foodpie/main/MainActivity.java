package com.example.dllo.foodpie.main;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.my.MyFragment;
import com.example.dllo.foodpie.foodcyclopedia.FoodCyclopediaFragment;
import com.example.dllo.foodpie.goeat.GoEatFragment;
import com.example.dllo.foodpie.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button BtnFood;
    private Button BtnGoEat;
    private Button BtnMy;
    private FragmentManager manager;

    private List<Button> bottomBtns;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        BtnFood = bindView(R.id.btn_foodcyclopedia);
        BtnGoEat = bindView(R.id.btn_goeat);
        BtnMy = bindView(R.id.btn_my);

        bottomBtns = new ArrayList<>();
        bottomBtns.add(BtnFood);
        bottomBtns.add(BtnGoEat);
        bottomBtns.add(BtnMy);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout, new FoodCyclopediaFragment());
        BtnFood.setSelected(true);

        transaction.commit();

        setClick(this, BtnFood, BtnGoEat, BtnMy);


    }

    @Override
    protected void initData() {

    }

    public void setSelectBtn(int name) {
        for (int i = 0; i < bottomBtns.size(); i++) {
            if (i == name) {
                bottomBtns.get(name).setSelected(true);
                continue;
            }
            bottomBtns.get(name).setSelected(false);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_foodcyclopedia:
                transaction.replace(R.id.layout, new FoodCyclopediaFragment());
                setSelectBtn(0);
                break;
            case R.id.btn_goeat:
                transaction.replace(R.id.layout, new GoEatFragment());
                setSelectBtn(1);
                break;
            case R.id.btn_my:
                transaction.replace(R.id.layout, new MyFragment());
                setSelectBtn(2);
                break;
        }
        transaction.commit();

    }
}
