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

/**
 * Created by dllo on 16/10/24.
 */
public class FoodCyclopediaFragment extends BaseFragment implements AdapterView.OnItemClickListener {
 private GridView gridview;

String url ="http://food.boohee.com/fb/v1/categories/list";
    private ArrayList<FoodTextBean> arrayList;
    private GridViewAdapter gridViewAdapter;
    private GridViewSecondAdapter adaptersecond;
    private GridViewThirdAdapter adapterthird;
    private GridView gridviewsecond;
    private GridView gridviewthird;

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


        gridview.setOnItemClickListener(this);


    }



    @Override
    protected void initDate() {
        initGridViewFirst();
        initGridViewSecond();
        initGridViewThird();

    }

    private void initGridViewThird() {
  Gsonrequest<FoodBean> gsonrequest = new Gsonrequest<FoodBean>(FoodBean.class, url,
          new Response.Listener<FoodBean>() {
              @Override
              public void onResponse(FoodBean response) {
ArrayList<FoodTextBean > array = new ArrayList<>();
                  for (int i = 0; i <response.getGroup().get(2).getCategories().size() ; i++) {
                      FoodTextBean bean = new FoodTextBean();
                      bean.setName(response.getGroup().get(2).getCategories().get(i).getName());
                      bean.setImage_url(response.getGroup().get(2).getCategories().get(i).getImage_url());
                      array.add(bean);
                  }


                  adapterthird = new GridViewThirdAdapter(getContext());
                  adapterthird.setArrayList(array);
                  gridviewthird.setAdapter(adapterthird);



              }
          }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {

      }
  });
        VolleySingletion.getInstance().addRequest(gsonrequest);


    }

    private void initGridViewSecond() {

        Gsonrequest<FoodBean> gsonrequest = new Gsonrequest<FoodBean>(FoodBean.class, url,
                new Response.Listener<FoodBean>() {

                    ArrayList<FoodTextBean> array = new ArrayList<>();
                    @Override
                    public void onResponse(FoodBean response) {

                        for (int i = 0; i < response.getGroup().get(1).getCategories().size(); i++) {
                            FoodTextBean bean = new FoodTextBean();
                            bean.setName(response.getGroup().get(1).getCategories().get(i).getName());
                            bean.setImage_url(response.getGroup().get(1).getCategories().get(i).getImage_url());
                            array.add(bean);

                            adaptersecond = new GridViewSecondAdapter(getContext());
                            adaptersecond.setArrayList(array);
                          gridviewsecond.setAdapter(adaptersecond);

                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingletion.getInstance().addRequest(gsonrequest);

    }

    private void initGridViewFirst() { Gsonrequest<FoodBean> gsonrequest = new Gsonrequest<FoodBean>(FoodBean.class, url,
            new Response.Listener<FoodBean>() {
                @Override
                public void onResponse(FoodBean response) {

                    for (int i = 0; i < response.getGroup().get(0).getCategories().size(); i++) {
                        FoodTextBean bean = new FoodTextBean();

                        bean.setName(response.getGroup().get(0).getCategories().get(i).getName());
                        bean.setImage_url(response.getGroup().get(0).getCategories().get(i).getImage_url());
                        arrayList.add(bean);
                    }
                    gridViewAdapter = new GridViewAdapter();



                    gridview.setAdapter(gridViewAdapter);
                    gridViewAdapter.setArrayList(arrayList);


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
