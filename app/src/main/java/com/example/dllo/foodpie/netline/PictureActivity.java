package com.example.dllo.foodpie.netline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.bean.FirstBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureActivity extends BaseActivity implements View.OnClickListener {

    private ImageView bigimage;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat_first_picture;
    }

    @Override
    protected void initView() {

        Button btnback = bindView(R.id.btn_goeat_first_picture);

         

        setClick(this,btnback);


    }

    @Override
    protected void initData() {






    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
