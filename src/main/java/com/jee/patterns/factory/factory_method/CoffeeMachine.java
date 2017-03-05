package com.jee.patterns.factory.factory_method;

import com.jee.patterns.factory.abstract_factory.CoffeeType;
import com.jee.patterns.factory.abstract_factory.model.Expresso;
import com.jee.patterns.factory.abstract_factory.model.Latte;
import com.jee.patterns.factory.factory_method.model.Coffee;
import com.jee.patterns.factory.factory_method.model.Drink;

/**
 * Created by Иван on 05.03.2017.
 */
public class CoffeeMachine extends DrinksMachine {
    @Override
    public Drink dispenseDrink() {
        return new Coffee();
    }

    public Drink dispenseDrink(CoffeeType type) {
        switch (type) {
            case LATTE:
                return getLatte();
            case EXPRESSO:
                return getExpresso();
        }
        return dispenseDrink();
    }

    protected Expresso getExpresso() {
        return new Expresso();
    }

    protected Latte getLatte() {
        return new Latte();
    }
}
