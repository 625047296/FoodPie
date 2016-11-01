package com.example.dllo.foodpie.goeatfragment.goodfoodfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.goeatfragment.firstfragment.GoeatFirstAdapter;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */
public class GoodFoodAdapter extends BaseAdapter {
//    public static final int VALUE_MORE = 1;

    ArrayList<GoodFoodTextBean> arrayList;


    public void setArrayList(ArrayList<GoodFoodTextBean> arrayList) {
        this.arrayList = arrayList;
    }

    Context context;

    public GoodFoodAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position).getContent_type();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);


        if (type == 0) {
            MyyViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_goeat_goodfood, parent, false);
                viewHolder = new MyyViewHolder(convertView);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (MyyViewHolder) convertView.getTag();
            }

            viewHolder.tvTitle.setText(arrayList.get(position).getTitle());
            viewHolder.tvSource.setText(arrayList.get(position).getSource());
            viewHolder.tvTail.setText(arrayList.get(position).getTail());
            VolleySingletion.getInstance().getImage(arrayList.get(position).getImages().get(0), viewHolder.ivGoodFood);




        } else if (type == 1) {

            MyyViewHolder2 viewHolder2 = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_goeat_goodfoodtwo, parent, false);
                viewHolder2 = new MyyViewHolder2(convertView);
                convertView.setTag(viewHolder2);

            } else {
                viewHolder2 = (MyyViewHolder2) convertView.getTag();
            }
            viewHolder2.tvTitletwo.setText(arrayList.get(position).getTitle());
            viewHolder2.tvSourcetwo.setText(arrayList.get(position).getSource());
            viewHolder2.tvTailtwo.setText(arrayList.get(position).getTail());

            VolleySingletion.getInstance().getImage(arrayList.get(position).getImages().get(0), viewHolder2.imageViewfirst);
            VolleySingletion.getInstance().getImage(arrayList.get(position).getImages().get(1), viewHolder2.imageviewsecond);
            VolleySingletion.getInstance().getImage(arrayList.get(position).getImages().get(2), viewHolder2.imageviewthird);

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        int type = arrayList.get(position).getContent_type();
        return type - 1;
    }

    @Override
    public int getViewTypeCount() {

        return 2;
    }


    class MyyViewHolder {
        private ImageView ivGoodFood;
        private TextView tvTitle;
        private TextView tvTail;
        private TextView tvSource;

        public MyyViewHolder(View convertView) {
            ivGoodFood = (ImageView) convertView.findViewById(R.id.iv_goodfoodimage);
            tvTitle = (TextView) convertView.findViewById(R.id.tv_goodfoodgetitle);
            tvTail = (TextView) convertView.findViewById(R.id.tv_goodfood_tail);
            tvSource = (TextView) convertView.findViewById(R.id.tv_goodfoodsource);

        }
    }

    class MyyViewHolder2 {

        private TextView tvTitletwo;
        private TextView tvTailtwo;
        private TextView tvSourcetwo;
        private ImageView imageViewfirst;
        private ImageView imageviewsecond;
        private ImageView imageviewthird;

        public MyyViewHolder2(View convertView) {

            tvTitletwo = (TextView) convertView.findViewById(R.id.tv_goodfoodtwogetitle);
            tvTailtwo = (TextView) convertView.findViewById(R.id.tv_goodfoodtwo_tail);
            tvSourcetwo = (TextView) convertView.findViewById(R.id.tv_goodfoodtwosource);
            imageViewfirst = (ImageView) convertView.findViewById(R.id.iv_goodfoodtwofirstimage);
            imageviewsecond = (ImageView) convertView.findViewById(R.id.iv_goodfoodtwosecondimage);
            imageviewthird = (ImageView) convertView.findViewById(R.id.iv_goodfoodtwothirdimage);


        }
    }


}