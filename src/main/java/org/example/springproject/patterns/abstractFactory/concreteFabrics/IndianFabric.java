package org.example.springproject.patterns.abstractFactory.concreteFabrics;

import org.example.springproject.patterns.abstractFactory.Coffee;
import org.example.springproject.patterns.abstractFactory.CoffeeFabric;
import org.example.springproject.patterns.abstractFactory.concreteCoffe.RobustCoffee;

public class IndianFabric extends CoffeeFabric {
    @Override
    protected Coffee produceCoffee() {
        return new RobustCoffee();
    }
}
