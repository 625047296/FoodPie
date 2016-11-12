package com.example.dllo.foodpie.enter;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText etId;
    private EditText etPassWord;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        Button btnBack = bindView(R.id.btn_back_login);
        Button btnLogin = bindView(R.id.btn_login_login);
        etId = bindView(R.id.et_login_id);
        etPassWord = bindView(R.id.et_login_password);
        setClick(this,btnBack,btnLogin);


    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_login:
                finish();
                break;
            case R.id.btn_login_login:
                Login();
                break;
        }
    }

    //注册
    private void Login() {
        BmobUser login = new BmobUser();
        String id = etId.getText().toString();
        String passWord = etPassWord.getText().toString();
        if (id.equals("") || passWord.equals("")) {
            Toast.makeText(this, "请输入完整的注册账号和密码", Toast.LENGTH_SHORT).show();
        } else {
            login.setUsername(id);
            login.setPassword(passWord);
            login.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser login, BmobException e) {
                    if (e == null) {
                        Toast.makeText(LoginActivity.this, "注册成功,请返回上级界面登录", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d("LoginActivity", e.getMessage());
                        Toast.makeText(LoginActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
