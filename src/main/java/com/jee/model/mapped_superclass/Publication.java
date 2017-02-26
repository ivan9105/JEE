package com.jee.model.mapped_superclass;

import com.jee.model.StandardEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Иван on 21.02.2017.
 */
@MappedSuperclass
public abstract class Publication implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @Column(name = "title")
    protected String title;

    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "publishingDate")
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
}
