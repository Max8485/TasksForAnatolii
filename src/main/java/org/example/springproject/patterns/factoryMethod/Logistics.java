package org.example.springproject.patterns.factoryMethod;

public abstract class Logistics {   //Creator
    public abstract Transport createTransport();    // Фабричный метод (ключевой!)

    // Бизнес-логика, использующая продукт
    public void planDelivery() {
        Transport transport = createTransport(); // создание через фабричный метод
        transport.deliver();
        System.out.println("Маршрут спланирован");
    }
}
