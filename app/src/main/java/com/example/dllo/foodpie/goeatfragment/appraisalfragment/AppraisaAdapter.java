package com.example.dllo.foodpie.goeatfragment.appraisalfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/28.
 */
public class AppraisaAdapter extends BaseAdapter{

    ArrayList<AppraisaTextBean > appraisaTextBeen;

    public void setAppraisaTextBeen(ArrayList<AppraisaTextBean> appraisaTextBeen) {
        this.appraisaTextBeen = appraisaTextBeen;
    }
    Context context;

    public AppraisaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return appraisaTextBeen == null ? 0 : appraisaTextBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return appraisaTextBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goeat_appraisa,parent,false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(appraisaTextBeen.get(position).getTitle());
        viewHolder.source.setText(appraisaTextBeen.get(position).getSource());
      viewHolder.tail.setText(appraisaTextBeen.get(position).getTail());
        VolleySingletion.getInstance().getImage(appraisaTextBeen.get(position).getBackground(),viewHolder.iv);
        return convertView;
    }

    private class MyyViewHolder {

        private  ImageView iv;
        private  TextView title;
        private  TextView tail;
        private  TextView source;

        public MyyViewHolder(View convertView) {
            iv = (ImageView) convertView.findViewById(R.id.iv_item_appraisa_background);
            title = (TextView) convertView.findViewById(R.id.tv_item_appraisa_title);
            tail = (TextView) convertView.findViewById(R.id.tv_item_appraisa_tail);
            source = (TextView) convertView.findViewById(R.id.tv_item_appraisa_source);
        }
    }
}
