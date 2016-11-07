package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionPopBean;
import com.example.dllo.foodpie.goeat.first.GoEatFirstAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/5.
 */
public class PopFoodDescriptionAdapter extends BaseAdapter {

    private List<FoodDescriptionPopBean.TypesBean> types;

    public void setTypes(List<FoodDescriptionPopBean.TypesBean> types) {
        this.types = types;
        notifyDataSetChanged();
    }

    private Context context;

    public PopFoodDescriptionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return types == null ? 0 : types.size();
    }

    @Override
    public Object getItem(int position) {
        return types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_description_pop, parent, false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.popTv.setText(types.get(position).getName());



        return convertView;
    }

    private class MyyViewHolder {

        private  TextView popTv;

        public MyyViewHolder(View convertView) {
            popTv = (TextView) convertView.findViewById(R.id.tv_item_description_pop_code);
        }
    }
}
