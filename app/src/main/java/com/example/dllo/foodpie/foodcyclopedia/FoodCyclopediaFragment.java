package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodBean;
import com.example.dllo.foodpie.netline.FoodCyclopediaActivity;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopediaFragment extends BaseFragment implements AdapterView.OnItemClickListener {


    private GridViewAdapter gridViewAdapter, gridViewAdapterSecond, gridViewAdapterThird;
    private GridView gridviewsecond;
    private GridView gridviewthird;
    private GridView gridview;
    private List<FoodBean.GroupBean.CategoriesBean> categories;
    private ArrayList<FoodBean> bean  ;
    private String king;

    @Override
    protected int getLayout() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView() {
        gridview = bindView(R.id.gv_food);
        gridviewsecond = bindView(R.id.gvtwo_food);

        gridviewthird = bindView(R.id.gvthree_food);


        gridViewAdapter = new GridViewAdapter();
        gridViewAdapterSecond = new GridViewAdapter();
        gridViewAdapterThird = new GridViewAdapter();


        gridview.setOnItemClickListener(this);


    }


    @Override
    protected void initData() {

        initGridViewFirst();

    }


    private void initGridViewFirst() {
        GsonreQuest<FoodBean> gsonreQuest = new GsonreQuest<FoodBean>(FoodBean.class, UrlNet.FoodCyclopediaurl,
                new Response.Listener<FoodBean>() {


                    @Override
                    public void onResponse(FoodBean response) {
                        for (int j = 0; j < 3; j++) {

                            for (int i = 0; i < response.getGroup().get(j).getCategories().size(); i++) {
                                categories = response.getGroup().get(j).getCategories();
                                if (response.getGroup().get(j).getKind().equals("group")){
                                    king = response.getGroup().get(j).getKind();
                                }else if (response.getGroup().get(j).getKind().equals("brand")){
                                    king = response.getGroup().get(j).getKind();
                                }else {
                                    king = response.getGroup().get(j).getKind();
                                }

//                                Log.d("FoodCyclopediaFragment1", king);
                            }
                            switch (j) {
                                case 0:
                                    gridViewAdapter.setArrayList(categories);
                                    gridview.setAdapter(gridViewAdapter);
                                    break;
                                case 1:
                                    gridViewAdapterSecond.setArrayList(categories);
                                    gridviewsecond.setAdapter(gridViewAdapterSecond);
                                    break;
                                case 2:
                                    gridViewAdapterThird.setArrayList(categories);
                                    gridviewthird.setAdapter(gridViewAdapterThird);
                                    break;
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingletion.getInstance().addRequest(gsonreQuest);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Intent intent = new Intent(getActivity(), FoodCyclopediaActivity.class);
        Log.d("FoodCyclopediaFragment2", king);
     String kind = king ;
      int foodId= categories.get(position).getId();

        Log.d("55", "bean:" + bean);
        intent.putExtra("kind",kind);
        intent.putExtra("id",foodId);

        startActivity(intent);
    }


}
