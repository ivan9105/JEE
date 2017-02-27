package com.jee.model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity(name = "projects")
public class Project extends Module {
    @Column
    protected String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
