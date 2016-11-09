package com.example.dllo.foodpie.foodcyclopedia;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.tools.EventInfo;
import com.example.dllo.foodpie.tools.UrlNet;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class FoodSearchActivity extends BaseActivity implements View.OnClickListener {

    private EditText etSearch;
    private ImageView ivSearch;


    @Override
    protected int getLayout() {
        return R.layout.activity_food_search;
    }

    @Override
    protected void initView() {
        etSearch = bindView(R.id.et_food_search);
        ivSearch = bindView(R.id.iv_food_search);
        setClick(this, ivSearch);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_food_search, new SearchBeforeFragment());

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

//        Intent intent = new Intent(this,SearchAfterFragment.class);
      //发送
        EventBus.getDefault().post(new EventInfo( etSearch.getText().toString()));
//        intent.putExtra("editText", ss);
//        startActivity(intent);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_food_search, new SearchAfterFragment());
        transaction.commit();

    }





    }
