package org.example.springproject.livecode.tasks.Anatolii;

import lombok.Data;

import java.util.*;

@Data
public class TravelDto {
    public static void main(String[] args) {
        List<TravelDto> travels = Arrays.asList(
                new TravelDto("Москва", "Санкт-Петербург", "Максим"),
                new TravelDto("Санкт-Петербург", "Москва", "Максим"),

                new TravelDto("Москва", "Мурманск", "Иван"),
                new TravelDto("Мурманск", "Ярославль", "Иван"),

                new TravelDto("Москва", "Владивосток", "Виктор"),
                new TravelDto("Владивосток", "Москва", "Виктор")
        );

        System.out.println(transformListToMap(travels));
        System.out.println(getLastLocations("Максим", travels));
    }

    private String from; // название города откуда
    private String to; // название города куда
    private String fullName; //имя человека

    public TravelDto(String from, String to, String fullName) {
        this.from = from;
        this.to = to;
        this.fullName = fullName;
    }

    //метод должен возвращает Мар (имя, набор городов)
    public static Map<String, Set<String>> transformListToMap(List<TravelDto> travels) {
        Map<String, Set<String>> personCity = new HashMap<>(); //key - fullname, value - у каждого человека свой set

        for (TravelDto travel : travels) {
            String personName = travel.getFullName();
            String from = travel.getFrom();
            String to = travel.getTo();

            // Если ключа нет, создаем новое HashSet
            if (!personCity.containsKey(personName)) { //либо так //Set<String> cities = personCity.getOrDefault(personName, new HashSet<>());
                personCity.put(personName, new HashSet<>());
            }

            Set<String> cities = personCity.get(personName);
            cities.add(from);
            cities.add(to);
        }
        return personCity;
    }

    //вернуть последний город, в котором был человек
    public static String getLastLocations(String fullName, List<TravelDto> travels) {
        return travels.stream()
                .filter(t -> t.getFullName().equals(fullName))
                .reduce((first, second) -> second)
                .map(TravelDto::getTo)
                .orElse(null);
    }
}
