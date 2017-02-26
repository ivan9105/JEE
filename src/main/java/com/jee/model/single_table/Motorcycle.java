package com.jee.model.single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity(name = "motorcycles")
@DiscriminatorValue("Motorcycle")
public class Motorcycle extends Vehicle {
    @Column
    protected boolean sport;

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }
}
