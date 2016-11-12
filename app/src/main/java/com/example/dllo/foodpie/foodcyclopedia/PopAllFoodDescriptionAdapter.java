package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionPopAllBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class PopAllFoodDescriptionAdapter extends BaseAdapter {
    private OnNutrientClick onNutrientClick;

    ArrayList<FoodDescriptionPopAllBean> allBeen;
    public void setOnNutrientClick(OnNutrientClick onNutrientClick) {
        this.onNutrientClick = onNutrientClick;
    }

    public void setAllBeen(ArrayList<FoodDescriptionPopAllBean> allBeen) {
        this.allBeen = allBeen;
    }
    private Context context;

    public PopAllFoodDescriptionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return allBeen == null ? 0 : allBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return allBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fooddescription_pop_all,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.tv_all.setText(allBeen.get(position).getName());
        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNutrientClick.setOnNutrentClick(String.valueOf(allBeen.get(position).getId()));
            }
        });
        return convertView;
    }

    private class MyyViewHolder {

        private  TextView tv_all;
        private  LinearLayout ll;

        public MyyViewHolder(View convertView) {
            tv_all = (TextView) convertView.findViewById(R.id.tv_item_description_pop_all);
            ll = (LinearLayout) convertView.findViewById(R.id.ll_dialog_description_pop_all);
        }
    }
}
