package org.example.springproject.patterns.builder;

import org.example.springproject.patterns.builder.concreateBuilders.ApplePhoneBuilder;

public class BuilderMain {
    public static void main(String[] args) {
        //Паттерн Строитель(Builder) позволяет отделить построение сложного обьекта от его представления
        //     Один из лучших способов создания сложных объектов
        //    Состоит из:
        //     1)Product -класс, определящий сложный обьект
        //     2)Builder -абстрактный класс либо интерфейс, определяющий все этапы для производства Product
        //     3)ConcreteBuilder - класс строитель, предоставляющий фактический код для создания продукта(их может
        //      быть много)
        //     4) Director - класс, под контролем которого Строитель строит обект поэтапно(Обычно получает на вход
        //      Строителя) обычно класс директора присутствует,если важен порядок "сборки" продукта

        PhoneBuilder builder = new ApplePhoneBuilder();
        PhoneEngineer engineer = new PhoneEngineer(builder); //Director
        Phone phone = engineer.manufacturePhone();
        if (phone != null) {
            System.out.println("Phone delivered! It is: ");
            System.out.println(phone.toString());
        }
    }
}

//Сборка памяти Apple Iphone
//Сборка дисплея Apple Iphone
//Нанесение логотипа на Apple Iphone...
//Телефон доставлен! Это:
//Телефон{объем памяти=256, диагональ дисплея=101,1, бренд="Apple"}