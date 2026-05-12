package org.example.springproject.patterns.factoryMethod;

import org.example.springproject.patterns.factoryMethod.concreteCreator.RoadLogistics;
import org.example.springproject.patterns.factoryMethod.concreteCreator.ShipLogistics;

public class FactoryMethodMain {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        Logistics shipLogistics = new ShipLogistics();
        shipLogistics.planDelivery();
    }
}
//Участники:

//Product — интерфейс продуктов (общий для всех создаваемых объектов)

//ConcreteProduct — конкретные реализации продукта

//Creator — абстрактный класс/интерфейс с фабричным методом

//ConcreteCreator — переопределяет фабричный метод, возвращая конкретный продукт

//В Factory Method используется наследование — конкретный создатель наследуется от абстрактного и переопределяет фабричный метод.
// В Abstract Factory используется композиция — клиенту передаётся готовая фабрика, реализующая абстрактный интерфейс.
// Продукты в обоих паттернах имеют общие интерфейсы."

//"Factory Method — порождающий паттерн, который делегирует создание объектов наследникам.
// Он решает проблему привязки кода к конкретным классам.

// Вместо прямого вызова new, мы объявляем абстрактный метод createProduct в базовом классе.
// Например, в логистическом приложении базовый класс Logistics объявляет метод createTransport,
// а RoadLogistics и ShipLogistics создают Truck и Ship соответственно.
// Бизнес-метод planDelivery работает с Transport через полиморфизм.
// В Java классический пример — метод iterator() у коллекций.
// От Abstract Factory отличается тем, что создаёт один продукт через наследование, а не семейство через композицию."
