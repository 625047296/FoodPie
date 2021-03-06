package com.example.dllo.foodpie.goeat.knowledge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.bean.KnowledgeBean;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public class KnowledgeAdapter extends BaseAdapter {

    private List<KnowledgeBean.FeedsBean> arrayList;

    public void setArrayList(List<KnowledgeBean.FeedsBean> arrayList) {
        this.arrayList = arrayList;
    }

    private Context mContext;

    public KnowledgeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyyViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_goeat_knowledge, parent, false);
            viewHolder = new MyyViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (MyyViewHolder) convertView.getTag();
        }
        viewHolder.tvtail.setText(arrayList.get(position).getTail());
        viewHolder.tvTitle.setText(arrayList.get(position).getTitle());
        viewHolder.tvSource.setText(arrayList.get(position).getSource());
        VolleySingletion.getInstance().getImage(arrayList.get(position).getImages().get(0), viewHolder.iv);


        return convertView;
    }

    private class MyyViewHolder {

        private TextView tvTitle;
        private TextView tvSource;
        private ImageView iv;
        private final TextView tvtail;

        public MyyViewHolder(View convertView) {
            tvtail = (TextView) convertView.findViewById(R.id.tv_knowledge_tail);
            tvTitle = (TextView) convertView.findViewById(R.id.tv_knowledgetitle);
            tvSource = (TextView) convertView.findViewById(R.id.tv_knowledgesource);
            iv = (ImageView) convertView.findViewById(R.id.iv_knowledgeimage);
        }
    }
}
