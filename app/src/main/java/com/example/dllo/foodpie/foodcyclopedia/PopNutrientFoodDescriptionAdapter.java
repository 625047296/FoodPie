package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.FoodDescriptionPopNutrientBean;

import java.util.List;

/**
 * Created by dllo on 16/11/5.
 */
public class PopNutrientFoodDescriptionAdapter extends BaseAdapter {
   private OnNutrientClick onNutrientClick;
    private List<FoodDescriptionPopNutrientBean.TypesBean> types;

    public void setTypes(List<FoodDescriptionPopNutrientBean.TypesBean> types) {
        this.types = types;
       notifyDataSetChanged();
    }

    public void setOnNutrientClick(OnNutrientClick onNutrientClick) {
        this.onNutrientClick = onNutrientClick;
    }

    private Context context;

    public PopNutrientFoodDescriptionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return types == null ? 0 : types.size();
    }

    @Override
    public Object getItem(int position) {
        return types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_description_pop, parent, false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.popTv.setText(types.get(position).getName());
        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onNutrientClick.setOnNutrentClick(types.get(position).getIndex());
            }
        });


        return convertView;
    }

    private class MyyViewHolder {

        private  TextView popTv;
        private  LinearLayout ll;

        public MyyViewHolder(View convertView) {
            popTv = (TextView) convertView.findViewById(R.id.tv_item_description_pop_code);
            ll = (LinearLayout) convertView.findViewById(R.id.ll_dialog_description_pop_nutrient);
        }
    }
}
