package com.example.dllo.foodpie.foodcyclopedia;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.MyApp;
import com.example.dllo.foodpie.bean.FoodCyclopediaBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.List;

/**
 * Created by dllo on 16/10/26.
 */
public class FoodCyclopediaAdapter extends BaseAdapter {
    private OnClick onClick;
    private FoodCyclopediaBean foodCyclopediaBean;
    private int kind = 10;

    public void setFoodCyclopediaBean(int kind, FoodCyclopediaBean foodCyclopediaBean) {
        this.foodCyclopediaBean = foodCyclopediaBean;
        this.kind = kind;
        notifyDataSetChanged();
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getCount() {
//        int count =foodCyclopediaBean.getGroup() == null ? 0 : foodCyclopediaBean.getGroup().size();
        //   Log.d("GridViewAdapter", "count:" + count);
        return foodCyclopediaBean.getGroup().get(kind).getCategories() == null ? 0 : foodCyclopediaBean.getGroup().get(kind).getCategories().size();


    }

    @Override
    public Object getItem(int position) {
        return foodCyclopediaBean.getGroup().get(kind);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_food_gridview, parent, false);
            viewHolder = new MyyViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(foodCyclopediaBean.getGroup().get(kind).getCategories().get(position).getName());
        VolleySingletion.getInstance().getImage(foodCyclopediaBean.getGroup().get(kind).getCategories().get(position).getImage_url(), viewHolder.imageView);

        Log.d("FoodCyclopediaAdapter", "foodCyclopediaBean.getGroup().get(kind).getCategories():" + foodCyclopediaBean.getGroup().get(kind).getCategories());

        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
//            List<FoodCyclopediaBean.GroupBean.CategoriesBean.SubCategoriesBean> been ;

            @Override
            public void onClick(View v) {
                onClick.onClickSms(foodCyclopediaBean.getGroup().get(kind).getKind(),
            foodCyclopediaBean.getGroup().get(kind).getCategories().get(position).getId(),

            foodCyclopediaBean.getGroup().get(kind).getCategories().get(position).getName(),

            foodCyclopediaBean.getGroup().get(kind).getCategories().get(position).getSub_categories()


                );
            }
        });
        return convertView;
    }


    private class MyyViewHolder {


        private ImageView imageView;
        private TextView textView;
        private LinearLayout ll;

        public MyyViewHolder(View convertView) {

            imageView = (ImageView) convertView.findViewById(R.id.iv_gridviewitem);
            textView = (TextView) convertView.findViewById(R.id.tv_gridviewitem);
            ll = (LinearLayout) convertView.findViewById(R.id.ll_food_homepage);

        }
    }
}
