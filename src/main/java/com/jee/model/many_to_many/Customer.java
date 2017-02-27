package com.jee.model.many_to_many;

import com.jee.model.StandardEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Иван on 27.02.2017.
 */
@Entity(name = "customers")
public class Customer implements StandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    protected List<Product> products;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
