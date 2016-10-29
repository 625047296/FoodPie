package com.example.dllo.foodpie.goeatfragment.appraisalfragment;

import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.foodpie.R;
import com.example.dllo.foodpie.base.BaseFragment;
import com.example.dllo.foodpie.netrequest.Gsonrequest;
import com.example.dllo.foodpie.netrequest.VolleySingletion;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class AppraisalFragment extends BaseFragment {

    String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=2&per=10";
    private ListView lv;
    private AppraisaAdapter appraisaAdapter;
ArrayList<AppraisaTextBean > beann ;
    @Override
    protected int getLayout() {
        return R.layout.frament_goeat_appraisal;
    }

    @Override
    protected void initView() {
        lv = BindView(R.id.iv_appraisa);
        appraisaAdapter = new AppraisaAdapter(getContext());
       beann = new ArrayList<>();
    }

    @Override
    protected void initDate() {

        Gsonrequest<AppraisaBean> gsonrequest = new Gsonrequest<AppraisaBean>(AppraisaBean.class, url,
                new Response.Listener<AppraisaBean>() {
                    @Override
                    public void onResponse(AppraisaBean response) {
                        for (int i = 0; i < response.getFeeds().size(); i++) {
                            AppraisaTextBean bean = new AppraisaTextBean();
                            bean.setTitle(response.getFeeds().get(i).getTitle());
                            bean.setSource(response.getFeeds().get(i).getSource());
                            bean.setTail(response.getFeeds().get(i).getTail());
                            bean.setBackground(response.getFeeds().get(i).getBackground());
                            beann.add(bean);
                        }
                        appraisaAdapter.setAppraisaTextBeen(beann);
                        lv.setAdapter(appraisaAdapter);




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingletion.getInstance().addRequest(gsonrequest);


    }
}
