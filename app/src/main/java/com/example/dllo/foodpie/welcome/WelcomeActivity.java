package com.example.dllo.foodpie.welcome;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.foodcyclopedia.MainActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv;
    private ImageView im;
    private boolean timeIsClosed = false;

    @Override
    protected int getLayout() {
        return R.layout.welcome_pager;
    }

    @Override
    protected void initView() {
        im = bindView(R.id.iv_welcome);
        tv = bindView(R.id.tv_welcome);
        setClick(this, im);

    }

    @Override
    protected void initDate() {
         ininTime();
    }

    private void ininTime() {

        CountDownTimer timer = new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText(millisUntilFinished/1000+"秒");


            }

            @Override
            public void onFinish() {
                if (timeIsClosed = false){

                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                }
            }
        };
        timer.start();


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        timeIsClosed =! timeIsClosed;
    }
}
