package org.example.springproject.patterns.factoryMethod;

public class Ship implements Transport{  //ConcreteProduct
    @Override
    public void deliver() {
        System.out.println("Доставка по морю (корабль)");
    }
}
