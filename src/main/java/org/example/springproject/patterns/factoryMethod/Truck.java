package org.example.springproject.patterns.factoryMethod;

public class Truck implements Transport{ //ConcreteProduct
    @Override
    public void deliver() {
        System.out.println("Доставка по земле (грузовик)");
    }
}
