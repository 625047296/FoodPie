package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionPopAllBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class PopAllFoodDescriptionAdapter extends BaseAdapter {
    ArrayList<FoodDescriptionPopAllBean> allBeen;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fooddescription_pop_all,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.tv_all.setText(allBeen.get(position).getName());

        return convertView;
    }

    private class MyyViewHolder {

        private  TextView tv_all;

        public MyyViewHolder(View convertView) {
            tv_all = (TextView) convertView.findViewById(R.id.tv_item_description_pop_all);
        }
    }
}
