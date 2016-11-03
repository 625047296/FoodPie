package com.example.dllo.foodpie.goeat.first;

/**
 * Created by dllo on 16/10/26.
 */
public class FirstTextBean {

    private String title;
    private String card_image;
    private String publisher;
    private String description;
    private  String publisher_avatar;
    private String Link;
    private int content_type;

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

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
