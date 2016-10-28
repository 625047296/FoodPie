package com.example.dllo.foodpie.goeatfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GoeatAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments ;

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    String[] strings = {"首页","测评","知识","美食"};



    public GoeatAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();

    }

    @Override
    public CharSequence getPageTitle(int position)  {
        return strings[position];
    }
}
