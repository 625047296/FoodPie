package com.example.dllo.foodpie.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.enter.EnterActivity;
import com.example.dllo.foodpie.options.SetActivity;
import com.example.dllo.foodpie.tools.CircleImageView;

import cn.bmob.v3.BmobUser;

/**
 * Created by dllo on 16/10/21.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private Button btn;
    private Button btnLogin;
    private TextView tvName;
    private Button btnPerson;
    private CircleImageView ivIcon;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        LinearLayout photo = bindView(R.id.photo_my);
        LinearLayout order = bindView(R.id.order_my);
        LinearLayout upload = bindView(R.id.upload_my);
        LinearLayout collect = bindView(R.id.collect_my);
        ivIcon = bindView(R.id.iv_my);
        tvName = bindView(R.id.tv_my_name);
        btn = bindView(R.id.btn_my);
        btnPerson = bindView(R.id.btn_my_person);
        btnLogin = bindView(R.id.btn_my_login);
        setClick(this,btn,photo,order,upload,collect,btnLogin);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_my:
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
                break;
            case R.id.photo_my:
//                Intent intent1 = new Intent(getActivity(), EnterActivity.class);
//                startActivity(intent1);
                break;
            case R.id.order_my:
//                Intent intent2 = new Intent(getActivity(), EnterActivity.class);
//                startActivity(intent2);
                break;
            case R.id.collect_my:
//                Intent intent3 = new Intent(getActivity(), EnterActivity.class);
//                startActivity(intent3);
                break;
            case R.id.upload_my:
//                Intent intent4 = new Intent(getActivity(), EnterActivity.class);
//                startActivity(intent4);
                break;
            case R.id.btn_my_login:
                Intent intent5 = new Intent(getActivity(), EnterActivity.class);
                startActivity(intent5);
                break;

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null){
            btnLogin.setVisibility(View.INVISIBLE);
            btnPerson.setVisibility(View.VISIBLE);
           tvName.setText(bmobUser.getUsername());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.diao);
           ivIcon.setImageBitmap(bitmap);

        }else {
            btnLogin.setVisibility(View.VISIBLE);
            btnPerson.setVisibility(View.INVISIBLE);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img_default_avatar);
      ivIcon.setImageBitmap(bitmap);
             tvName.setText("");
        }
    }
}
