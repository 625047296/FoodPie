package com.example.dllo.foodpie.foodcyclopediafragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopediaFragment extends BaseFragment implements AdapterView.OnItemClickListener {


    String url = "http://food.boohee.com/fb/v1/categories/list";
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
        gridview = BindView(R.id.gv_food);
        gridviewsecond = BindView(R.id.gvtwo_food);

        gridviewthird = BindView(R.id.gvthree_food);


        gridViewAdapter = new GridViewAdapter();
        gridViewAdapterSecond = new GridViewAdapter();
        gridViewAdapterThird = new GridViewAdapter();

        gridview.setOnItemClickListener(this);


    }


    @Override
    protected void initDate() {

        initGridViewFirst();

    }


    private void initGridViewFirst() {
        Gsonrequest<FoodBean> gsonrequest = new Gsonrequest<FoodBean>(FoodBean.class, url,
                new Response.Listener<FoodBean>() {
                    @Override
                    public void onResponse(FoodBean response) {
                        for (int j = 0; j < 3; j++) {
                            ArrayList<FoodTextBean> foodTextBeen = new ArrayList<>();

                            for (int i = 0; i < response.getGroup().get(j).getCategories().size(); i++) {
                                FoodTextBean bean = new FoodTextBean();

                                bean.setName(response.getGroup().get(j).getCategories().get(i).getName());
                                bean.setImage_url(response.getGroup().get(j).getCategories().get(i).getImage_url());
                                foodTextBeen.add(bean);
                            }
                            switch (j) {
                                case 0:
                                    gridViewAdapter.setArrayList(foodTextBeen);
                                    gridview.setAdapter(gridViewAdapter);
                                    break;
                                case 1:
                                    gridViewAdapterSecond.setArrayList(foodTextBeen);
                                    gridviewsecond.setAdapter(gridViewAdapterSecond);
                                    break;
                                case 2:
                                    gridViewAdapterThird.setArrayList(foodTextBeen);
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
        VolleySingletion.getInstance().addRequest(gsonrequest);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


}
