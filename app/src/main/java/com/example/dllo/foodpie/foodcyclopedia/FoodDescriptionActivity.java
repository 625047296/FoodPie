package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.util.Log;
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
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.bean.FoodDescriptionPopAllBean;
import com.example.dllo.foodpie.bean.FoodDescriptionPopNutrientBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.ArrayList;
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
    private PopupWindow popupWindowButrient;
    private GridView gridViewNutrient;
    private LinearLayout llNutrient;
    private PopNutrientFoodDescriptionAdapter popNutrientAdapter;
    private List<FoodDescriptionPopNutrientBean.TypesBean> types;
    private Button btnBack;
    private LinearLayout llAll;
    private PopupWindow popupWindowAll;

    private List<FoodCyclopediaBean.GroupBean.CategoriesBean.SubCategoriesBean> categories;
    private ListView lv_pop_all;
    private PopAllFoodDescriptionAdapter popAllFoodDescriptionAdapter;


    @Override
    protected int getLayout() {
        return R.layout.activity_foodcyclopedia;
    }
    @Override
    protected void initView() {
        adapter = new FoodDescriptionActivityAdapter(this);
        lv = bindView(R.id.lv_foodcyclopedia);
        nameTv = bindView(R.id.tv_name_description);
        btnBack = bindView(R.id.btn_back_description);
        llNutrient = bindView(R.id.ll_dialog_description_nutrient);
        llAll = bindView(R.id.ll_dialog_description_all);

        setClick(this, btnBack, llNutrient,llAll);
        //接收上一级的信息
        Intent intent = getIntent();
        kind = intent.getStringExtra("kind");
        name = intent.getStringExtra("name");
 categories = (List<FoodCyclopediaBean.GroupBean.CategoriesBean.SubCategoriesBean>) this.getIntent().getSerializableExtra("categories");
        Log.d("FoodDescriptionActivity", "categories:" + categories);
        nameTv.setText(name);
        idInfo = String.valueOf(intent.getIntExtra("idInfo", -1));
        popNutrientAdapter =  new PopNutrientFoodDescriptionAdapter(this);
        popAllFoodDescriptionAdapter = new PopAllFoodDescriptionAdapter(this);




    }
    //食物百科二级网络在详情里点击营养素排列显示的pop
    //营养素的popWindow

    private void initNutrientPop() {
      //初始化pop
        View viewNutrient = getLayoutInflater().inflate(R.layout.item_fooddescription_nutrient_pop,null);
        popupWindowButrient = new PopupWindow(viewNutrient,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        gridViewNutrient = (GridView) viewNutrient.findViewById(R.id.gv_description_nutrient_pop);

        popupWindowButrient.showAsDropDown(llNutrient,0,0);

        gsonNutrientPop();
    }
//从食物百科Fragment传过来的值,进行字符串拼接
    @Override
    protected void initData() {

        String url = UrlNet.beforeFoodCyclopediaurlActivity + kind + "&value=" + idInfo + UrlNet.afterFoodCyclopediaurlActivity;
        GsonRequest<FoodDescriptionBean> gsonRequest = new GsonRequest<FoodDescriptionBean>(FoodDescriptionBean.class,
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
        VolleySingletion.getInstance().addRequest(gsonRequest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_description:

                 onBackPressed();
            break;
            case R.id.ll_dialog_description_nutrient:


          if (popupWindowButrient == null || !popupWindowButrient.isShowing()){
                 initNutrientPop();
           }else if (popupWindowButrient.isShowing()){
              popupWindowButrient.dismiss();
          }

                break;
            case  R.id.ll_dialog_description_all:
                if (popupWindowAll == null || !popupWindowAll.isShowing()){
                    initAllPop();
                    gsonAllPop();


                }else if (popupWindowAll.isShowing()){
                    popupWindowAll.dismiss();
                }
                break;


    }}

    private void initAllPop() {
        View viewAll = getLayoutInflater().inflate(R.layout.item_fooddescription_all_pop,null);
        lv_pop_all = (ListView)viewAll.findViewById(R.id.lv_food_description_pop_all);

        popupWindowAll =
                new PopupWindow(viewAll, 300,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindowAll.showAsDropDown(llAll,0,0);
    }
    private  void gsonAllPop() {
        ArrayList<FoodDescriptionPopAllBean> been = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {

            FoodDescriptionPopAllBean array = new FoodDescriptionPopAllBean();
            array.setId(categories.get(i).getId());
            array.setName(categories.get(i).getName());
            been.add(array);
        }

        popAllFoodDescriptionAdapter.setAllBeen(been);
        lv_pop_all.setAdapter(popAllFoodDescriptionAdapter);

    }

        //pop的解析

    private void gsonNutrientPop() {

        GsonRequest<FoodDescriptionPopNutrientBean> gsonRequest = new GsonRequest<FoodDescriptionPopNutrientBean>(FoodDescriptionPopNutrientBean.class
                , UrlNet.FoodCyclopediaurlDescriptionPop, new Response.Listener<FoodDescriptionPopNutrientBean>() {
            @Override
            public void onResponse(FoodDescriptionPopNutrientBean response) {

                types = response.getTypes();
                popNutrientAdapter.setTypes(types);
                gridViewNutrient.setAdapter(popNutrientAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gsonRequest);



    }
}
