package org.example.springproject.patterns.factoryMethod.concreteCreator;

import org.example.springproject.patterns.factoryMethod.Logistics;
import org.example.springproject.patterns.factoryMethod.Ship;
import org.example.springproject.patterns.factoryMethod.Transport;

public class ShipLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
