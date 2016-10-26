package com.example.dllo.foodpie.MyActivity.info.foodcyclopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.MyApp;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/26.
 */
public class GridView_Adapter extends BaseAdapter{

   ArrayList<FoodBean> arrayList;

    public void setArrayList(ArrayList<FoodBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList == null? 0 :arrayList.size();
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
            convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.gridview_item,parent,false);
            viewHolder = new MyyViewHolder(convertView);

             convertView.setTag(viewHolder);
        }else{
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(arrayList.get(position).getName());
       viewHolder.imageView.setImageResource(Integer.parseInt(arrayList.get(position).getImageId()));



        return convertView;
    }


    private class MyyViewHolder {


        private final ImageView imageView;
        private final TextView textView;

        public MyyViewHolder(View convertView) {

            imageView = (ImageView) convertView.findViewById(R.id.iv_gridviewitem);
            textView = (TextView) convertView.findViewById(R.id.tv_gridviewitem);

        }
    }
}
