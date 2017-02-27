package com.jee.model.joined;

/**
 * Created by Иван on 26.02.2017.
 */

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "courses")
public class Course extends Module {
    @Column
    protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
