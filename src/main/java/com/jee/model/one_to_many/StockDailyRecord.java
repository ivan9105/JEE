package com.jee.model.one_to_many;

import com.jee.model.StandardEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Иван on 28.02.2017.
 */
@Entity(name = "stock_records")
public class StockDailyRecord implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @Column
    protected Float priceOpen;

    @Column
    protected Float priceClose;

    @Column
    protected Float priceChange;

    @Column
    protected Long volume;

    @Column
    protected Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", nullable = false)
    protected Stock stock;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getPriceOpen() {
        return priceOpen;
    }

    public void setPriceOpen(Float priceOpen) {
        this.priceOpen = priceOpen;
    }

    public Float getPriceClose() {
        return priceClose;
    }

    public void setPriceClose(Float priceClose) {
        this.priceClose = priceClose;
    }

    public Float getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Float priceChange) {
        this.priceChange = priceChange;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
