package com.example.dllo.foodpie.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/11/12.
 */
public class SearchRecordBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
