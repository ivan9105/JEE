package com.jee.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Иван on 28.02.2017.
 */
@Embeddable
public class Address {
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
