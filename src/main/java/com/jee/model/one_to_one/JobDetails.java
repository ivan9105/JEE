package com.jee.model.one_to_one;

import com.jee.model.StandardEntity;

import javax.persistence.*;

/**
 * Created by Иван on 27.02.2017.
 */
@Entity(name = "jobDetails")
public class JobDetails implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    protected Job job;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
