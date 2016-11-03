package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
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


    private ArrayList<FoodTextBean> arrayList;
    private GridViewAdapter gridViewAdapter, gridViewAdapterSecond, gridViewAdapterThird;
    private GridView gridviewsecond;
    private GridView gridviewthird;
    private GridView gridview;

    @Override
    protected int getLayout() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView() {
        arrayList = new ArrayList<>();
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
                    private List<FoodBean.GroupBean.CategoriesBean> categories;



                    @Override
                    public void onResponse(FoodBean response) {
                        for (int j = 0; j < 3; j++) {
                            ArrayList<FoodTextBean> foodTextBeen = new ArrayList<>();

                            for (int i = 0; i < response.getGroup().get(j).getCategories().size(); i++) {
//                                FoodTextBean bean = new FoodTextBean();
                                categories = response.getGroup().get(j).getCategories();

//                                bean.setName(response.getGroup().get(j).getCategories().get(i).getName());
//                                bean.setImage_url(response.getGroup().get(j).getCategories().get(i).getImage_url());
//                                foodTextBeen.add(bean);
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
   startActivity(intent);
    }


}
