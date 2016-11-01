package com.example.dllo.foodpie.netline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected int getLayout() {
        return R.layout.activity_goeat_first_picture;
    }

    @Override
    protected void initView() {
        Button btnback = bindView(R.id.btn_goeat_first_picture);
        ImageView bigimage = bindView(R.id.iv_goeat_first_picturebig);
        setClick(this,btnback);


    }

    @Override
    protected void initDate() {






    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
