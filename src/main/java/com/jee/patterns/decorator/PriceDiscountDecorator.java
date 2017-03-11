package com.jee.patterns.decorator;


import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

/**
 * Created by Иван on 05.03.2017.
 */
@Priority(Interceptor.Priority.APPLICATION)
@Decorator
public class PriceDiscountDecorator implements Product {

    @Any
    @Inject
    @Delegate
    private Product product;

    @Override
    public void setLabel(String label) {
        product.setLabel(label);
    }

    @Override
    public void setPrice(double price) {
        product.setPrice(price);
    }

    @Override
    public String getLabel() {
        return product.getLabel();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public String generateLabel() {
        product.setPrice(product.getPrice() * 0.5);
        product.setLabel(product.getLabel() + " (Discounted)");
        return product.generateLabel();
    }
}
