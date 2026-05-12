package org.example.springproject.patterns.abstractFactory.concreteCoffe;

import org.example.springproject.patterns.abstractFactory.Coffee;

public class ArabicCoffee extends Coffee {
    @Override
    protected void printCoffeeColor() {
        System.out.println("printing the color of arabic coffee...It's brown");

    }
}
