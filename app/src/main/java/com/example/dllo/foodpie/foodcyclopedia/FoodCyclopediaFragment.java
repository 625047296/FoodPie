package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Intent;
import android.util.Log;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.netrequest.GsonreQuest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.tools.UrlNet;

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopediaFragment extends BaseFragment implements OnClick {


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
        gridview = bindView(R.id.gv_food);
        gridviewsecond = bindView(R.id.gvtwo_food);

        gridviewthird = bindView(R.id.gvthree_food);

        gridViewAdapter = new GridViewAdapter();
        gridViewAdapterSecond = new GridViewAdapter();
        gridViewAdapterThird = new GridViewAdapter();

    }


    @Override
    protected void initData() {

        initGridViewFirst();
        gridViewAdapter.setOnClick(this);
        gridViewAdapterSecond.setOnClick(this);
        gridViewAdapterThird.setOnClick(this);

    }

    private void initGridViewFirst() {
        GsonreQuest<FoodCyclopediaBean> gsonreQuest = new GsonreQuest<FoodCyclopediaBean>(FoodCyclopediaBean.class, UrlNet.FoodCyclopediaurl,
                new Response.Listener<FoodCyclopediaBean>() {
                    @Override
                    public void onResponse(FoodCyclopediaBean response) {

                        gridViewAdapter.setFoodCyclopediaBean(0, response);
                        gridview.setAdapter(gridViewAdapter);
                        gridViewAdapterSecond.setFoodCyclopediaBean(1, response);
                        gridviewsecond.setAdapter(gridViewAdapterSecond);
                        gridViewAdapterThird.setFoodCyclopediaBean(2, response);
                        gridviewthird.setAdapter(gridViewAdapterThird);

//                     for (int j = 0; j < response.getGroup().size(); j++) {
//
//
//
//                            for (int i = 0; i < response.getGroup().get(j).getCategories().size(); i++) {
//                                idInfo = response.getGroup().get(j).getCategories().get(i).getId();
//                                Log.d("FoodCyclopediaFragment3", "idInfo:" + idInfo);
//                                categories = response.getGroup().get(j).getCategories();
//                            }
//                                switch (j) {
//                                    case 0:
//                                        gridViewAdapter.setArrayList(response);
//                                        gridview.setAdapter(gridViewAdapter);
//                                        kind = response.getGroup().get(0).getKind();
//                                        Log.d("FoodCyclopediaFragment1", kind);
//                                        break;
//                                    case 1:
//                                        gridViewAdapterSecond.setArrayList(response);
//                                        gridviewsecond.setAdapter(gridViewAdapterSecond);
//                                        kind = response.getGroup().get(1).getKind();
//                                        break;
//                                    case 2:
//                                        gridViewAdapterThird.setArrayList(response);
//                                        kind = response.getGroup().get(2).getKind();
//                                        gridviewthird.setAdapter(gridViewAdapterThird);
//                                        break;
//                                }
//                  }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingletion.getInstance().addRequest(gsonreQuest);

    }

    @Override
    public void onClickSms(String kind, int id, String name) {
        Intent intent = new Intent(getActivity(), FoodDescriptionActivity.class);

        intent.putExtra("kind", kind);
        intent.putExtra("idInfo", id);
        intent.putExtra("name",name);
        Log.d("FoodCyclopediaFragment0", "idInfo:" + id);
        Log.d("FoodCyclopediaFragment0", kind);
        startActivity(intent);
    }

}
