package org.example.springproject.livecode.tasks.Anatolii;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task5 {             //подумать, что выводится при каждом sout

    public static void main(String[] args) {

        Set<Person> setPersons = new HashSet<>();
        setPersons.add(new Person("alex", "2"));
        setPersons.add(new Person("sergei", "3"));
        setPersons.add(new Person("alex", "2"));

        System.out.println(setPersons.size()); //должен вывести 3

        var streamPerson = setPersons.stream();
        System.out.println(streamPerson
                .map(Person::getName)
                .collect(Collectors.joining(", ")) //должен вывести одной строкой имена через запятую
        );

        List<String> listAges = setPersons.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        System.out.println(listAges); //так работает!


//        System.out.println(streamPerson //здесь мы пытаемся переиспользовать завершенный stream //IllegalStateException
//                .map(Person::getAge)
//                .collect(Collectors.toList()) //должен вывести список с возрастами
//        );
    }

    public static class Person {
        private final String name;  //final поля
        private final String age;

        public Person(String name, String age) {
            this.age = age;
            this.name = name;
        }

        public String getName() {  //только геттеры
            return name;
        }

        public String getAge() {
            return age;
        }
    }
}
