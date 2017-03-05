package com.jee.patterns.factory.abstract_factory;

import com.jee.patterns.factory.factory_method.DrinksMachine;

/**
 * Created by Иван on 05.03.2017.
 */
public interface AbstractDrinksMachineFactory {
    DrinksMachine createCoffeeMachine();
    DrinksMachine createSoftMachine();
}
