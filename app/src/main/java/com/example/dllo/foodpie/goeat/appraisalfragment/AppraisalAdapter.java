package com.example.dllo.foodpie.goeat.appraisalfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.AppraisaBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.List;

/**
 * Created by dllo on 16/10/28.
 * 测评
 */
public class AppraisalAdapter extends BaseAdapter {

    private List<AppraisaBean.FeedsBean> appraisalTextBeen;

    public void setAppraisalTextBeen(List<AppraisaBean.FeedsBean> appraisalTextBeen) {
        this.appraisalTextBeen = appraisalTextBeen;
    }

    private Context context;

    public AppraisalAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return appraisalTextBeen == null ? 0 : appraisalTextBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return appraisalTextBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goeat_appraisa, parent, false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(appraisalTextBeen.get(position).getTitle());
        viewHolder.source.setText(appraisalTextBeen.get(position).getSource());
        viewHolder.tail.setText(appraisalTextBeen.get(position).getTail());
        VolleySingletion.getInstance().getImage(appraisalTextBeen.get(position).getBackground(), viewHolder.iv);
        return convertView;
    }

    private class MyyViewHolder {

        private ImageView iv;
        private TextView title;
        private TextView tail;
        private TextView source;

        public MyyViewHolder(View convertView) {
            iv = (ImageView) convertView.findViewById(R.id.iv_item_appraisa_background);
            title = (TextView) convertView.findViewById(R.id.tv_item_appraisa_title);
            tail = (TextView) convertView.findViewById(R.id.tv_item_appraisa_tail);
            source = (TextView) convertView.findViewById(R.id.tv_item_appraisa_source);
        }
    }
}
