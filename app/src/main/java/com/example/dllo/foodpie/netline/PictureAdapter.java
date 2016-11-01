package com.example.dllo.foodpie.netline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.foodpie.goeatfragment.firstfragment.FirstBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/1.
 */
public class PictureAdapter extends BaseAdapter{
    Context context;

    public PictureAdapter(Context context) {
        this.context = context;
    }
    ArrayList<FirstBean> arrayList;

    public void setArrayList(ArrayList<FirstBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
