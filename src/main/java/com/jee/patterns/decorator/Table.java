package com.jee.patterns.decorator;

import javax.enterprise.context.Dependent;

/**
 * Created by Иван on 05.03.2017.
 */
@Dependent
@ClearanceSale
public class Table implements Product {
    private String label = "Dining Table";
    private double price = 100.00;

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String generateLabel() {
        return String.format("%s. %s", price, label);
    }
}
