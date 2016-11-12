package com.example.dllo.foodpie.tools;

import java.util.List;

/**
 * Created by dllo on 16/11/3.
 */
public final class UrlNet {

    public static int Page = 1;
    public static final  String KnowledgeUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=" + Page + "&category=3&per=10";
    public static final  String GoodFoodUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=2&category=4&per=10";
    public static final  String AppraisalUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=" + Page + "&category=2&per=10";
    public static final  String FirstUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    public static final  String FoodCyclopediaurl = "http://food.boohee.com/fb/v1/categories/list";
    public static final  String beforeFoodCyclopediaurlActivity = "http://food.boohee.com/fb/v1/foods?kind=";
    public static final  String afterFoodCyclopediaurlActivity = "&page=1&order_asc=0";
    public static final  String FoodCyclopediaurlDescriptionPop = "http://food.boohee.com/fb/v1/foods/sort_types";
    public static final  String FoodSearch = "http://food.boohee.com/fb/v1/search?page=1&order_asc=desc&q=";
    public static final  String FoodSearchBeafore = "http://food.boohee.com/fb/v1/keywords?token=&user_key=&app_version=2.6";
}
