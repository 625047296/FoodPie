package com.example.dllo.foodpie.goeat.first;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBig;
    private String image;
    private ImageView ivsmall;
    private String icon;
    private TextView nameTv;
    private String name;
    private String like;
    private TextView likeTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_goeat_first_picture;
    }

    @Override
    protected void initView() {

        Button btnback = bindView(R.id.btn_goeat_first_picture);

        Intent intent = getIntent();
        image = intent.getStringExtra("image");
        icon = intent.getStringExtra("headIcon");
        name = intent.getStringExtra("name");
        like = intent.getStringExtra("Like_ct");

         ivBig = (ImageView) findViewById(R.id.iv_goeat_first_picturebig);
        ivsmall = (ImageView) findViewById(R.id.iv_goeat_first_picture);
        nameTv = (TextView) findViewById(R.id.name_picture);
        likeTv = (TextView) findViewById(R.id.lick_ct_picture);



        nameTv.setText(name);
         likeTv.setText(like);
        VolleySingletion.getInstance().getImage(image,ivBig);
        VolleySingletion.getInstance().getImage(icon,ivsmall);
        setClick(this, btnback);


    }

    @Override
    protected void initData() {

    }




    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
