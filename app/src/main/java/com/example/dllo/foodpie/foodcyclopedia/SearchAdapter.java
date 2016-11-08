package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/8.
 */
public class SearchAdapter extends BaseAdapter{
    ArrayList<FoodDescriptionBean> arrayList;
    private Context context;


    public void setArrayList(ArrayList<FoodDescriptionBean> arrayList) {
        this.arrayList = arrayList;
    }

    public SearchAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodcyclopedia,parent,false);


        }
        return null;
    }

    private class MyyViewHolder {
    }
}
