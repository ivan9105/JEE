package com.jee.patterns.factory.abstract_factory;

import com.jee.patterns.factory.abstract_factory.model.GourmetSoftDrink;
import com.jee.patterns.factory.factory_method.SoftDrinksMachine;
import com.jee.patterns.factory.factory_method.model.Drink;

/**
 * Created by Иван on 05.03.2017.
 */
public class GourmetSoftDrinkMachine extends SoftDrinksMachine {
    @Override
    public Drink dispenseDrink() {
        return new GourmetSoftDrink();
    }
}
