package com.example.dllo.foodpie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.foodpie.R;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayout() == 0){
            return inflater.inflate(R.layout.null_layout,container,false);
        }


        return inflater.inflate(getLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }
    protected <T extends View> T BindView(int id){
        return (T) getView().findViewById(id);
    }
    protected <T extends View> T BindView(View view, int id){
        return (T) view.findViewById(id);
    }

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initDate();

    protected void setClick(View.OnClickListener onClickListener,View ...views ){
        for (View view :views){
            view.setOnClickListener(onClickListener);
        }
    }
}
