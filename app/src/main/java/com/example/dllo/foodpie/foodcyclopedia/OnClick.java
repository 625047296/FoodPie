package com.example.dllo.foodpie.foodcyclopedia;

import com.example.dllo.foodpie.bean.FoodCyclopediaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/5.
 */
public interface OnClick {
    void onClickSms(String kind, int id, String name, List categories);
}
