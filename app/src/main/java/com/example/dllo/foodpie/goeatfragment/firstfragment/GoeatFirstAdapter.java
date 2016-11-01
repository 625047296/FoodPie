package com.example.dllo.foodpie.goeatfragment.firstfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class GoeatFirstAdapter extends RecyclerView.Adapter {

// private OnRecycleViewOnClickListener recycleviewonclick = null;
//
//    public void setRecycleviewonclick(OnRecycleViewOnClickListener recycleviewonclick) {
//        this.recycleviewonclick = recycleviewonclick;
//    }

    ArrayList<FirstTextBean> arrayList;


    OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }


    public void setArrayList(ArrayList<FirstTextBean> arrayList) {
        this.arrayList = arrayList;
    }

    private Context mContext;

    public GoeatFirstAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 5:
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_goeat_first, parent, false);

                MyViewHolder viewHolder = new MyViewHolder(view);
//                view.setOnClickListener(this);
                return viewHolder;
            case 6:

                View viewad = LayoutInflater.from(mContext).inflate(R.layout.item_goeat_firstad, parent, false);

                MyADViewHolder viewHolderad = new MyADViewHolder(viewad);
//                viewad.setOnClickListener(this);

                return viewHolderad;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 5:
                MyViewHolder viewHolder = (MyViewHolder) holder;
                viewHolder.tvPublisher.setText(arrayList.get(position).getPublisher());
                viewHolder.tvTitile.setText(arrayList.get(position).getTitle());
                viewHolder.itemView.setTag(arrayList.get(position));

                viewHolder.tvlike.setText(String.valueOf(arrayList.get(position).getLikect()));
                VolleySingletion.getInstance().getImage(arrayList.get(position).getCard_image(), viewHolder.iv);
                VolleySingletion.getInstance().getImage(arrayList.get(position).getPublisher_avatar(), viewHolder.ivhead);


                viewHolder.llFirst.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onClickItemListener.onClick(position);
                    }
                });

                break;

            case 6:

                final MyADViewHolder viewholderad = (MyADViewHolder) holder;

                VolleySingletion.getInstance().getImage(arrayList.get(position).getCard_image(), viewholderad.imageViewad);

//                ((MyADViewHolder) holder).llFirstAd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        onClickItemListener.onClick();
//                    }
//                });
                break;


        }


    }


    @Override
    public int getItemViewType(int position) {
        int type = arrayList.get(position).getContent_type();
        return type;
    }


    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tvTitile;
        private TextView tvPublisher;
        //   private TextView tvDescription;
        private ImageView ivhead;
        private TextView tvlike;
        private LinearLayout llFirst;


        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_first);
            tvTitile = (TextView) itemView.findViewById(R.id.tv_firstTitle);
            tvPublisher = (TextView) itemView.findViewById(R.id.tv_firstpublisher);
            //       tvDescription = (TextView) itemView.findViewById(R.id.tv_firstdescription);
            ivhead = (ImageView) itemView.findViewById(R.id.iv_firstpublisher_avatar);
            tvlike = (TextView) itemView.findViewById(R.id.tv_firstlike_ct);
            llFirst = (LinearLayout) itemView.findViewById(R.id.ll_first);

        }


    }

    public class MyADViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewad;
        private LinearLayout llFirstAd;

        public MyADViewHolder(View itemView) {
            super(itemView);
            imageViewad = (ImageView) itemView.findViewById(R.id.iv_firstad);
            llFirstAd = (LinearLayout) itemView.findViewById(R.id.ll_first_ad);

        }
    }

}


