package com.jee.patterns.decorator;

/**
 * Created by Иван on 05.03.2017.
 */
public interface Product {
    void setLabel(String label);
    void setPrice(double price);
    String getLabel();
    double getPrice();
    String generateLabel();
}
