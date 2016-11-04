package com.example.dllo.foodpie.bean;

import java.util.List;

/**
 * Created by dllo on 16/10/25.
 */
public class FirstBean {
    private String page;
    private int total_pages;

    private List<FeedsBean> feeds;


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public static class FeedsBean {
        private int item_id;
        private String title;
        private String card_image;
        private String publisher;
        private String publisher_avatar;
        private String description;
        private int content_type;
        private String type;
        private int like_ct;
        private String link;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
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

        public String getPublisher_avatar() {
            return publisher_avatar;
        }

        public void setPublisher_avatar(String publisher_avatar) {
            this.publisher_avatar = publisher_avatar;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getContent_type() {
            return content_type;
        }

        public void setContent_type(int content_type) {
            this.content_type = content_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLike_ct() {
            return like_ct;
        }

        public void setLike_ct(int like_ct) {
            this.like_ct = like_ct;
        }
    }

}