package com.jee.model.mapped_superclass;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Иван on 21.02.2017.
 */
@Entity(name = "books")
public class Book extends Publication {
    @Column(name = "pages")
    private int pages;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
