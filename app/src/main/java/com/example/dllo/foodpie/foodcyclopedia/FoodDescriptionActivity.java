package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseActivity;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.bean.FoodDescriptionPopBean;
import com.example.dllo.foodpie.foodcyclopedia.FoodDescriptionActivityAdapter;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.List;

/**
 * Created by dllo on 16/11/3.
 */
public class FoodDescriptionActivity extends BaseActivity implements View.OnClickListener {


    private FoodDescriptionActivityAdapter adapter;
    private List<FoodDescriptionBean.FoodsBean> foods;
    private ListView lv;
    private String kind;
    private String idInfo;
    private TextView nameTv;
    private String name;
    private PopupWindow popwindow;
    private GridView gv;
    private LinearLayout ll;
    private GridLayoutManager manager;

    @Override
    protected int getLayout() {
        return R.layout.activity_foodcyclopedia;
    }
    @Override
    protected void initView() {
        adapter = new FoodDescriptionActivityAdapter(this);
        lv = bindView(R.id.lv_foodcyclopedia);
        nameTv = bindView(R.id.tv_name_description);
        Button btnBack = bindView(R.id.btn_back_description);
        ll = (LinearLayout) findViewById(R.id.ll_dialog_description);
        setClick(this, btnBack,ll);
        Intent intent = getIntent();
        kind = intent.getStringExtra("kind");
        name = intent.getStringExtra("name");
        nameTv.setText(name);
        idInfo = String.valueOf(intent.getIntExtra("idInfo", -1));


    }

    private void initPop() {
               //初始化pop
            popwindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            View view = LayoutInflater.from(this).inflate(R.layout.item_pop_fooddescription,null);
        PopFoodDescriptionAdapter popadapter = new PopFoodDescriptionAdapter();


            popwindow.setContentView(view);

            gv = (GridView) findViewById(R.id.gv_item_description);
            gv.setOnClickListener(this);

            popwindow.showAsDropDown(ll,0,0);

        }




    @Override
    protected void initData() {
//        String url1 = "http://food.boohee.com/fb/v1/foods?kind="+kind+"&value="+idInfo+"&order_by=1&page=1&order_asc=0";
//        Log.d("FoodCyclopediaActivity", url1);
        String url = UrlNet.beforeFoodCyclopediaurlActivity + kind + "&value=" + idInfo + UrlNet.afterFoodCyclopediaurlActivity;
//        Log.d("FoodCyclopediaActivity", url);
        GsonreQuest<FoodDescriptionBean> gsonreQuest = new GsonreQuest<FoodDescriptionBean>(FoodDescriptionBean.class,
                url, new Response.Listener<FoodDescriptionBean>() {
            @Override
            public void onResponse(FoodDescriptionBean response) {
                foods = response.getFoods();
                adapter.setFoodsBeanList(foods);
                lv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gsonreQuest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_description:
        onBackPressed();
            break;
            case R.id.ll_dialog_description:
                GsonPop();
                initPop();
                break;


    }}

    private void GsonPop() {

        GsonreQuest<FoodDescriptionPopBean> gsonreQuest = new GsonreQuest<FoodDescriptionPopBean>()



    }
}
