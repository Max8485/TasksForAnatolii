package org.example.springproject.patterns.abstractFactory.concreteFabrics;

import org.example.springproject.patterns.abstractFactory.Coffee;
import org.example.springproject.patterns.abstractFactory.CoffeeFabric;
import org.example.springproject.patterns.abstractFactory.concreteCoffe.ArabicCoffee;

public class EthiopianFabric extends CoffeeFabric {
    @Override
    protected Coffee produceCoffee() {
        return new ArabicCoffee();
    }
}
