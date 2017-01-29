package com.example.em.emiliajakubowska;

import java.util.List;

/**
 * Created by Em on 2017-01-29.
 */

public class Image {
    private String imageUrl;
    private String title;
    private String desc;

    private List<Image> images = null;

    public List<Image> getImage() {
        return images;
    }

    public void setImage(List<Image> imageDetails) {
        this.images = imageDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
