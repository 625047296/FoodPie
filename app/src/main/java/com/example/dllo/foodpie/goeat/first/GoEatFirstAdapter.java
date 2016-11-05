package com.example.dllo.foodpie.goeat.first;

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
import com.example.dllo.foodpie.bean.FirstBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/25.
 */
public class GoEatFirstAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ONE_IMG = 6;
    private static  final int TYPE_MORE_IMG = 5;

    private OnClickItemListener onClickItemListener;

    private FirstBean firstBean;

    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
        notifyDataSetChanged();
    }

      public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;


    }




    private Context mContext;

    public GoEatFirstAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_MORE_IMG:
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_goeat_first, parent, false);

                MyViewHolder viewHolder = new MyViewHolder(view);
    //            view.setOnClickListener(this);
                return viewHolder;
            case TYPE_ONE_IMG:

                View viewad = LayoutInflater.from(mContext).inflate(R.layout.item_goeat_firstad, parent, false);

                MyADViewHolder viewHolderad = new MyADViewHolder(viewad);
    //           viewad.setOnClickListener(this);

                return viewHolderad;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,  final int position) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_MORE_IMG:
                MyViewHolder viewHolder = (MyViewHolder) holder;
                viewHolder.tvPublisher.setText(firstBean.getFeeds().get(position).getPublisher());
                viewHolder.tvTitile.setText(firstBean.getFeeds().get(position).getTitle());
                viewHolder.itemView.setTag(firstBean.getFeeds().get(position));

                viewHolder.tvlike.setText(String.valueOf(firstBean.getFeeds().get(position).getLike_ct()));
                VolleySingletion.getInstance().getImage(firstBean.getFeeds().get(position).getCard_image(), viewHolder.iv);
                VolleySingletion.getInstance().getImage(firstBean.getFeeds().get(position).getPublisher_avatar(), viewHolder.ivhead);


                viewHolder.llFirst.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Log.d("GoEatFirstAdapter", firstBean.getFeeds().get(position).getLink());
                       onClickItemListener.onClick(firstBean.getFeeds().get(position).getCard_image()
                               ,firstBean.getFeeds().get(position).getPublisher()
                               ,firstBean.getFeeds().get(position).getPublisher_avatar()
                               ,String.valueOf(firstBean.getFeeds().get(position).getLike_ct())
                               );
                    }
                });

                break;

            case TYPE_ONE_IMG:

                final MyADViewHolder viewholderad = (MyADViewHolder) holder;


                VolleySingletion.getInstance().getImage(firstBean.getFeeds().get(position).getCard_image(), viewholderad.imageViewad);

                ((MyADViewHolder) holder).llFirstAd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onClickItemListener.onPictureClick(firstBean.getFeeds().get(position).getLink());
                    }
                });
                break;


        }


    }


    @Override
    public int getItemViewType(int position) {
        int type = firstBean.getFeeds().get(position).getContent_type();
        return type;
    }


    @Override
    public int getItemCount() {
        return firstBean.getFeeds() == null ? 0 : firstBean.getFeeds().size();
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


