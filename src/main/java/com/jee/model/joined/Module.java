package com.jee.model.joined;

import com.jee.model.StandardEntity;

import javax.persistence.*;

/**
 * Created by Иван on 26.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Module implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @Column
    protected String name;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
