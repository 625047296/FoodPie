package com.example.dllo.foodpie.foodcyclopedia;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.events.EventInfo;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dllo on 16/11/8.
 */
public class FoodSearchActivity extends BaseActivity implements View.OnClickListener {

    private EditText etSearch;
    private ImageView ivSearch;
    private BaseFragment currentFragment;
    private FrameLayout fram;
    private String key;
    private FragmentManager manager;

    @Override
    protected int getLayout() {
        return R.layout.activity_food_search;
    }

    @Override
    protected void initView() {
        etSearch = bindView(R.id.et_food_search);
        ivSearch = bindView(R.id.iv_food_search);
        fram = bindView(R.id.fl_food_search);
        Button btnBack = bindView(R.id.btn_back_search);
        setClick(this, ivSearch, btnBack);
        SearchBeforeFragment searchBeforeFragment = new SearchBeforeFragment();
        currentFragment = searchBeforeFragment;
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_food_search, searchBeforeFragment);
        transaction.commit();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_food_search:
                if (currentFragment instanceof SearchAfterFragment) {

                    EventBus.getDefault().post(new EventInfo(etSearch.getText().toString()));

                } else {
                    SearchAfterFragment searchAfterFragment = new SearchAfterFragment();
                    //用Bundle传值
                    Bundle bundle = new Bundle();
                    bundle.putString("searchKey", etSearch.getText().toString());
                    searchAfterFragment.setArguments(bundle);
                    currentFragment = searchAfterFragment;

                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fl_food_search, searchAfterFragment);
                    transaction.commit();
                }

                break;
            case R.id.btn_back_search:
                onBackPressed();
                break;
        }
    }
//接收fragment 传递来得数据
    public void setKey(String key) {
        this.key = key;
        etSearch.setText(key);
    }
}
