package com.jee.model.single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity(name = "cars")
@DiscriminatorValue("Car")
public class Car extends Vehicle {
    @Column
    private int doorsCount;

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }
}
