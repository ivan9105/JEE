package com.jee.bean.product;

import com.jee.patterns.decorator.ClearanceSale;
import com.jee.patterns.decorator.Product;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by Иван on 11.03.2017.
 */
@Stateless(name = "ProductBean")
public class ProductBean {
    @Any
    @Inject
    @ClearanceSale
    private Product product;

    public String getLabel() {
        return product.generateLabel();
    }
}
