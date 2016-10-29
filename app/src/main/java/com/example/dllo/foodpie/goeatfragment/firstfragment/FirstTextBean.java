package com.example.dllo.foodpie.goeatfragment.firstfragment;

/**
 * Created by dllo on 16/10/26.
 */
public class FirstTextBean {

    private String title;
    private String card_image;
    private String publisher;
    private String description;
    private  String publisher_avatar;

    public String getPublisher_avatar() {
        return publisher_avatar;
    }

    public void setPublisher_avatar(String publisher_avatar) {
        this.publisher_avatar = publisher_avatar;
    }

    private int likect;

    public int getLikect() {
        return likect;
    }

    public void setLikect(int likect) {
        this.likect = likect;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCard_image() {
        return card_image;
    }

    public void setCard_image(String card_image) {
        this.card_image = card_image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
