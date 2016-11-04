package com.example.dllo.foodpie.netline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;

import com.example.dllo.foodpie.goeat.first.GoEatFirstAdapter;
import com.example.dllo.foodpie.netrequest.VolleySingletion;
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
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodcyclopedia,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(foodsBeanList.get(position).getName());
        VolleySingletion.getInstance().getImage(foodsBeanList.get(position).getThumb_image_url(),viewHolder.imageView);
          return convertView;
    }


    private class MyyViewHolder {


        private  TextView name;
        private  ImageView imageView;

        public MyyViewHolder(View convertView) {
            name = (TextView) convertView.findViewById(R.id.tv_foodcyclopedia_name);
            imageView = (ImageView) convertView.findViewById(R.id.iv_foodcyclopedia);
        }
    }
}
