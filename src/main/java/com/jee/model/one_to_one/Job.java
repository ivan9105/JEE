package com.jee.model.one_to_one;

import com.jee.model.StandardEntity;

import javax.persistence.*;

/**
 * Created by Иван on 27.02.2017.
 */
@Entity(name = "jobs")
public class Job implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @OneToOne(mappedBy = "job")
    protected JobDetails details;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JobDetails getDetails() {
        return details;
    }

    public void setDetails(JobDetails details) {
        this.details = details;
    }
}
