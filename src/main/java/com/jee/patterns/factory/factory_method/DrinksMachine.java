package com.jee.patterns.factory.factory_method;

import com.jee.patterns.factory.factory_method.model.Drink;

/**
 * Created by Иван on 05.03.2017.
 */
public abstract class DrinksMachine {
    public abstract Drink dispenseDrink();

    public String displayMessage() {
        return "Than for your custom";
    }
}
