package org.example.springproject.patterns.factoryMethod.concreteCreator;

import org.example.springproject.patterns.factoryMethod.Logistics;
import org.example.springproject.patterns.factoryMethod.Transport;
import org.example.springproject.patterns.factoryMethod.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
