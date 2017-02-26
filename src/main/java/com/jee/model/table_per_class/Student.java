package com.jee.model.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity(name = "students")
public class Student extends SchoolUser {
    @Column
    protected String profileName;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
