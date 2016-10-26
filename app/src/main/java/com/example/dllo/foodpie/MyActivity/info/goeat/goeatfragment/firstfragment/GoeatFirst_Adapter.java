package com.example.dllo.foodpie.MyActivity.info.goeat.goeatfragment.firstfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.MyApp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class GoeatFirst_Adapter extends RecyclerView.Adapter<GoeatFirst_Adapter.MyViewHolder>{

    ArrayList<FirstBean.FeedsBean> arrayList ;

    public void setArrayList(ArrayList<FirstBean.FeedsBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_firstgoeata,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.tvDescription.setText(arrayList.get(position).getDescription());
        holder.tvPublisher.setText(arrayList.get(position).getPublisher());
        holder.tvTitile.setText(arrayList.get(position).getTitle());
        Picasso.with(MyApp.getContext()).load(arrayList.get(position).getCard_image()).into(holder.iv);
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
