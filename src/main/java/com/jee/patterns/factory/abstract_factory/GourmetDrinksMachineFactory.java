package com.jee.patterns.factory.abstract_factory;

import com.jee.patterns.factory.factory_method.DrinksMachine;

/**
 * Created by Иван on 05.03.2017.
 */
public class GourmetDrinksMachineFactory implements AbstractDrinksMachineFactory {

    @Override
    public DrinksMachine createCoffeeMachine() {
        return new GourmetCoffeeMachine();
    }

    @Override
    public DrinksMachine createSoftMachine() {
        return new GourmetSoftDrinkMachine();
    }
}
