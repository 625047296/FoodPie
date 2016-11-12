package com.example.dllo.foodpie.foodcyclopedia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.bean.FoodDescriptionPopNutrientBean;
import com.example.dllo.foodpie.bean.SearchBean;
import com.example.dllo.foodpie.netrequest.GsonRequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
import com.example.dllo.foodpie.events.EventInfo;
import com.example.dllo.foodpie.tools.UrlNet;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchAfterFragment extends BaseFragment implements View.OnClickListener {
    private SearchAdapter searchAdapter;
    private String inPutUrl;
    private ListView lvSearch;
    private List<SearchBean.ItemsBean> items;
    private LinearLayout llNutrient;
    private ListView lv_pop_all;
    private PopupWindow popupWindowAll;
    private PopupWindow popupWindowButrient;
    private GridView gridViewNutrient;
    private List<FoodDescriptionPopNutrientBean.TypesBean> types;
    private PopNutrientFoodDescriptionAdapter popNutrientAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_seach_info;
    }

    @Override
    protected void initView() {
        lvSearch = bindView(R.id.lv_search_info);
        llNutrient = bindView(R.id.ll_dialog_search_nutrient);
        searchAdapter = new SearchAdapter();
        setClick(this, llNutrient);
        popNutrientAdapter = new PopNutrientFoodDescriptionAdapter(getActivity());


        //注册EventBus
        EventBus.getDefault().register(this);

    }


    //要@Subscribe让Eventbus找到方法

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventInfo(EventInfo event) {


        try {
            String result = URLEncoder.encode(event.getEditText(), "UTF-8");
            inPutUrl = UrlNet.FoodSearch + result;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        initGson();
    }

    //解析页面
    private void initGson() {

        GsonRequest<SearchBean> gson = new GsonRequest<SearchBean>(SearchBean.class, inPutUrl,
                new Response.Listener<SearchBean>() {
                    @Override
                    public void onResponse(SearchBean response) {
                        Log.d("SearchAfterFragment1", "response");
                        items = response.getItems();

                        searchAdapter.setItems(items);
                        lvSearch.setAdapter(searchAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SearchAfterFragment1", "error");
            }
        });
        VolleySingletion.getInstance().addRequest(gson);
    }

    //在这个方法里消除eventBus
    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    //接收在Activity里传来的值
    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String searchKey = bundle.getString("searchKey");
        EventInfo info = new EventInfo(searchKey);
        onEventInfo(info);
        initNutrientPop();

    }

    @Override
    public void onClick(View v) {

        if (popupWindowButrient == null || !popupWindowButrient.isShowing()) {

            popupWindowButrient.showAsDropDown(llNutrient, 0, 0);

        } else if (popupWindowButrient.isShowing()) {
            popupWindowButrient.dismiss();
        }

    }

    private void initNutrientPop() {
        //初始化pop
        View viewNutrient = LayoutInflater.from(getActivity()).inflate(R.layout.item_fooddescription_nutrient_pop, null);
        popupWindowButrient = new PopupWindow(viewNutrient, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        gridViewNutrient = (GridView) viewNutrient.findViewById(R.id.gv_description_nutrient_pop);


        // gsonNutrientPop();
    }

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
