package com.jee.patterns.factory.abstract_factory;

import com.jee.patterns.factory.abstract_factory.model.*;
import com.jee.patterns.factory.factory_method.CoffeeMachine;
import com.jee.patterns.factory.factory_method.model.Drink;

/**
 * Created by Иван on 05.03.2017.
 */
public class GourmetCoffeeMachine extends CoffeeMachine {
    @Override
    public Drink dispenseDrink() {
        return new GourmetCoffee();
    }

    @Override
    protected Expresso getExpresso() {
        return new GourmetExpresso();
    }

    @Override
    protected Latte getLatte() {
        return new GourmetLatte();
    }
}
