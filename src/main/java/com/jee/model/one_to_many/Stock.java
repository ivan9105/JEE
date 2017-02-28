package com.jee.model.one_to_many;

import com.jee.model.StandardEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Иван on 28.02.2017.
 */
@Entity(name = "stocks")
public class Stock implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @Column
    protected String code;

    @Column
    protected String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stock")
    protected List<StockDailyRecord> records;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<StockDailyRecord> getRecords() {
        return records;
    }

    public void setRecords(List<StockDailyRecord> records) {
        this.records = records;
    }
}
