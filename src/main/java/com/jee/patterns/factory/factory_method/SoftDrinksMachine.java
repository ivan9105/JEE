package com.jee.patterns.factory.factory_method;

import com.jee.patterns.factory.factory_method.model.Drink;
import com.jee.patterns.factory.factory_method.model.SoftDrink;

/**
 * Created by Иван on 05.03.2017.
 */
public class SoftDrinksMachine extends DrinksMachine {
    @Override
    public Drink dispenseDrink() {
        return new SoftDrink();
    }
}
