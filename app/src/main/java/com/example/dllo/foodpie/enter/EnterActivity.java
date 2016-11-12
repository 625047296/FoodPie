package com.example.dllo.foodpie.enter;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/10/29.
 * 登录界面
 */
public class EnterActivity extends BaseActivity implements View.OnClickListener {


    private Button btnBack;
    private ImageView enter;
    private EditText etId;
    private EditText etPassWord;
    private Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initView() {
        btnBack = bindView(R.id.btn_enter_back);
        enter = bindView(R.id.enter_boohee);
        etId = bindView(R.id.et_enter_id);
        etPassWord = bindView(R.id.et_enter_password);
        btnLogin = bindView(R.id.btn_enter_login);

        setClick(this, btnBack, enter, btnLogin);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_enter_back:
                onBackPressed();
                break;
            case R.id.enter_boohee:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_enter_login:
                BmobLogin();

                break;
        }

    }
//登录
    public void BmobLogin() {

        BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(etId.getText().toString());
        bmobUser.setPassword(etPassWord.getText().toString());
        bmobUser.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    Toast.makeText(EnterActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
          //倒计时
                    CountDownTimer timer = new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {
                         finish();
                        }
                    };
                    timer.start();


                } else {
                    Toast.makeText(EnterActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
