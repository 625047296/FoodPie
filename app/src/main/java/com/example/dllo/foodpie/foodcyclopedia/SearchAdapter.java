package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;
import com.example.dllo.foodpie.bean.SearchBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchAdapter extends BaseAdapter{
    private List<SearchBean.ItemsBean> items;

    public void setItems(List<SearchBean.ItemsBean> items) {
        this.items = items;
    }


    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            Context context = parent.getContext();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodcyclopedia,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.nameTv.setText(items.get(position).getName());
        viewHolder.weightTv.setText(items.get(position).getWeight());
        viewHolder.caloryTv.setText(items.get(position).getCalory());

        VolleySingletion.getInstance().getImage(items.get(position).getThumb_image_url(),viewHolder.iconIv);
        return convertView;
    }


    private class MyyViewHolder {


        private TextView nameTv;
        private ImageView iconIv;
        private  TextView weightTv;
        private  TextView caloryTv;

        public MyyViewHolder(View convertView) {
            nameTv = (TextView) convertView.findViewById(R.id.tv_foodcyclopedia_name);
            iconIv = (ImageView) convertView.findViewById(R.id.iv_foodcyclopedia);
            weightTv = (TextView) convertView.findViewById(R.id.tv_foodcyclopedia_weight);
            caloryTv = (TextView) convertView.findViewById(R.id.tv_foodcyclopedia_calory);

        }
    }
}
