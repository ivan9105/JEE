package com.jee.model.mapped_superclass;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Иван on 21.02.2017.
 */
@Entity(name = "blogPosts")
public class BlogPost extends Publication {
    @Column(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
