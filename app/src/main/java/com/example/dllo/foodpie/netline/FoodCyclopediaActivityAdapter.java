package com.example.dllo.foodpie.netline;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.goeat.first.GoEatFirstAdapter;
import com.example.dllo.foodpie.tools.CommonVH;

import java.util.List;

/**
 * Created by dllo on 16/11/3.
 */
public class FoodCyclopediaActivityAdapter extends BaseAdapter {
    private List<FoodCyclopediaBean.FoodsBean> foodsBeanList ;

    public void setFoodsBeanList(List<FoodCyclopediaBean.FoodsBean> foodsBeanList) {
        this.foodsBeanList = foodsBeanList;
    }
    private Context context;

    public FoodCyclopediaActivityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return foodsBeanList == null ? 0 : foodsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonVH  viewHolder =
                CommonVH.getViewHolder(convertView,parent, R.layout.item_foodcyclopedia);
          return viewHolder.getItemView();
    }



}
