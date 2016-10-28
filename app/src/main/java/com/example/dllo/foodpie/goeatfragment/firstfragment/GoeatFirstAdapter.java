package com.example.dllo.foodpie.goeatfragment.firstfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.MyApp;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class GoeatFirstAdapter extends RecyclerView.Adapter<GoeatFirstAdapter.MyViewHolder>{

   ArrayList<FirstTextBean > arrayList ;

    public void setArrayList(ArrayList<FirstTextBean> arrayList) {
        this.arrayList = arrayList;
    }

   private Context mContext;

    public GoeatFirstAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_goeat_first,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.tvDescription.setText(arrayList.get(position).getDescription());
        holder.tvPublisher.setText(arrayList.get(position).getPublisher());
        holder.tvTitile.setText(arrayList.get(position).getTitle());
        VolleySingletion.getInstance().getImage(arrayList.get(position).getCard_image(),holder.iv);
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tvTitile;
        private final TextView tvPublisher;
       private final TextView tvDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_first);
            tvTitile = (TextView) itemView.findViewById(R.id.tv_firstTitle);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_firstpublisher);
           tvDescription = (TextView) itemView.findViewById(R.id.tv_firstdescription);
        }
    }
}
