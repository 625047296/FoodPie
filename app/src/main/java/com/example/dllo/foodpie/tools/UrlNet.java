package com.example.dllo.foodpie.tools;

import java.util.List;

/**
 * Created by dllo on 16/11/3.
 */
public class UrlNet {

    public static int Page = 1;
    public static String kinds ;
    public static String KnowledgeUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=" + Page + "&category=3&per=10";
    public static String GoodFoodUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=2&category=4&per=10";
    public static String AppraisalUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=" + Page + "&category=2&per=10";
    public static String FirstUrl = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    public static String FoodCyclopediaurl = "http://food.boohee.com/fb/v1/categories/list";
    public static String beforeFoodCyclopediaurlActivity = "http://food.boohee.com/fb/v1/foods?kind=";
    public static String afterFoodCyclopediaurlActivity = "&order_by=1&page=1&order_asc=0";
}
