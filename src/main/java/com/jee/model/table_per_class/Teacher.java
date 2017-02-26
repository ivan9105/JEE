package com.jee.model.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity(name = "teachers")
public class Teacher extends SchoolUser {
    @Column
    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
