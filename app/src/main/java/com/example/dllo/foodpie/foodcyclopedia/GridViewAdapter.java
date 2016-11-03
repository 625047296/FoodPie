package com.example.dllo.foodpie.foodcyclopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.MyApp;
import com.example.dllo.foodpie.bean.FoodBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.List;

/**
 * Created by dllo on 16/10/26.
 */
public class GridViewAdapter extends BaseAdapter{

    List<FoodBean.GroupBean.CategoriesBean> arrayList;



    public void setArrayList(List<FoodBean.GroupBean.CategoriesBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        int count = arrayList == null? 0 :arrayList.size();
     //   Log.d("GridViewAdapter", "count:" + count);
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
            convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_food_gridview,parent,false);
            viewHolder = new MyyViewHolder(convertView);

             convertView.setTag(viewHolder);
        }else{
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(arrayList.get(position).getName());
        VolleySingletion.getInstance().getImage(arrayList.get(position).getImage_url(),viewHolder.imageView);



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
