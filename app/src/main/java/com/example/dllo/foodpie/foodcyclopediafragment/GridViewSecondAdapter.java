package com.example.dllo.foodpie.foodcyclopediafragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 */
public class GridViewSecondAdapter extends BaseAdapter{
    Context mContext;

    public GridViewSecondAdapter(Context mContext) {
        this.mContext = mContext;
    }

    ArrayList<FoodTextBean> arrayList;

    public void setArrayList(ArrayList<FoodTextBean> arrayList) {
        this.arrayList = arrayList;
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
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_food_gridviewtwo,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        VolleySingletion.getInstance().getImage(arrayList.get(position).getImage_url(),viewHolder.iv);
        viewHolder.tv.setText(arrayList.get(position).getName());

        return convertView;
    }

    private class MyyViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public MyyViewHolder(View convertView) {
            iv = (ImageView) convertView.findViewById(R.id.iv_gridviewseconditem);
            tv = (TextView) convertView.findViewById(R.id.tv_gridviewseconditem);

        }
    }
}
