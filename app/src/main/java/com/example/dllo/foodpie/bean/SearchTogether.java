package com.example.dllo.foodpie.bean;

import java.util.List;

/**
 * Created by dllo on 16/11/10.
 */
public class SearchTogether {

    /**
     * keyword_count : 10
     * keywords : ["苹果","香蕉","馒头","红薯","酸奶","米饭","玉米","鸡蛋","豆浆","草莓"]
     */

    private int keyword_count;
    private List<String> keywords;

    public int getKeyword_count() {
        return keyword_count;
    }

    public void setKeyword_count(int keyword_count) {
        this.keyword_count = keyword_count;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
