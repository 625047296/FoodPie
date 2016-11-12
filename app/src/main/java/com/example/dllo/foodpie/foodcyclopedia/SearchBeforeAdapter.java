package com.example.dllo.foodpie.foodcyclopedia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.goeat.first.OnClickItemListener;

import java.util.List;


/**
 * Created by dllo on 16/11/10.
 */
public class SearchBeforeAdapter extends RecyclerView.Adapter{
    private OnClickItemListener onClickItemListener;
    private List<String> keywords;

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_lv_search_beafore,parent,false);
        MyyViewHolder viewHolder = new MyyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyyViewHolder myyViewHolder = (MyyViewHolder) holder;
        myyViewHolder.tv.setText(keywords.get(position).toString());
        myyViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onPictureClick(keywords.get(position).toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return keywords == null ? 0 : keywords.size();
    }

    private class MyyViewHolder extends RecyclerView.ViewHolder {

        private  TextView tv;
        private  LinearLayout ll;

        public MyyViewHolder(View view) {
            super(view);
            ll = (LinearLayout) view.findViewById(R.id.ll_search_before);
            tv = (TextView) view.findViewById(R.id.tv_search_before);

        }
    }
}
