package org.example.springproject.livecode.tasks.Anatolii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestDriftParking {
    ////Найти лучшую парковку для дрифта парковку
    ////Лучшей будет парковка с наименьшей относительной заполненностью. Если есть две парковки с
    // одинаковой относительной заполненностью - выбрать ту что больше.

    ////Всего 1000, свободных 500
    ////Всего 1000, свободных 600
    ////Всего 500, свободных 400
    ////Всего 1000, свободных 800 ← best

    //parkingPlace
    //1 500 - свободных мест без машин
    //2 300
    //---
    //1 498 - свободных мест с машинами, всего 2 машины на парковке
    //2 257 - всего 43 машины на парковке

    ////1. Узнать сколько свободных мест на каждой парковке (абсолютное значение) - сделано!

    ////2. Посчитать относительную заполненность

    ////3. Если есть две парковки с одинаковой относительной заполненностью - выбрать ту что больше.

    public static void main(String[] args) {
        Parking parking1 = new Parking(1, 500); //498 - свободных мест
        Parking parking2 = new Parking(2, 1000); // 996 свободных мест, выведет id 2


        Car car1 = new Car(1, 1);
        Car car2 = new Car(2, 1);
        Car car3 = new Car(3, 2);
        Car car4 = new Car(4, 2);
        Car car5 = new Car(5, 2);
        Car car6 = new Car(6, 2);

        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(parking1);
        parkingList.add(parking2);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);

        BestDriftParking bestDriftParking = new BestDriftParking();
        System.out.println(bestDriftParking.calculateFreeSpacesAndRelativeOccupancy(parkingList, carList));
        System.out.println(bestDriftParking.findBestDriftParkingId(parkingList, carList));
    }

    private Map<Integer, Double> calculateFreeSpacesAndRelativeOccupancy(List<Parking> parkings, List<Car> cars) {
        Map<Integer, Integer> parkingPlace = new HashMap<>();
        for (Parking park : parkings) {
            parkingPlace.put(park.id, park.capacity);
        }

        // считаем, сколько машин стоит на каждой парковке:
        // пробегаем по списку машин, берем ID парковки и увеличиваем счетчик для этой парковки на 1.
        Map<Integer, Integer> carParking = new HashMap<>(); // ключ = ID парковки, значение = количество машин на парковке
        int carParkingId;
        for (Car car : cars) {
            carParkingId = car.parkingId;
            int currentCarCount = carParking.getOrDefault(carParkingId, 0);
            int carCountInParking = currentCarCount + 1;
            carParking.put(carParkingId, carCountInParking);
        }

        // вычисляем свободные места
        Map<Integer, Double> occupancyRates = new HashMap<>();
        for (Parking park : parkings) {
            int capacity = parkingPlace.get(park.id);
            int occupied = carParking.getOrDefault(park.id, 0);
            int free = capacity - occupied;

            double relativeOccupancy = (double) occupied / capacity; //относительная заполненность = занятые места / общая вместимость.

            occupancyRates.put(park.id, relativeOccupancy);

            System.out.printf("Парковка %d: вместимость=%d, занято=%d, свободно=%d, заполненность=%.2f%%%n",
                    park.id, capacity, occupied, free, relativeOccupancy * 100);
        }
        return occupancyRates;
    }

    // Наименьшая относительная заполненность (заполненность = занятые места / общая вместимость).
    // Если заполненность одинаковая - выбираем парковку с большей вместимостью.
    public int findBestDriftParkingId(List<Parking> parkings, List<Car> cars) {
        Map<Integer, Double> relativeOccupancy = calculateFreeSpacesAndRelativeOccupancy(parkings, cars);

        // Находим парковку с наименьшей заполненностью
        return parkings.stream()
                .min((p1, p2) -> {
                    double fill1 = relativeOccupancy.get(p1.id);
                    double fill2 = relativeOccupancy.get(p2.id);

                    if (Math.abs(fill1 - fill2) < 0.0001) {
                        // Одинаковая заполненность - выбираем с большей вместимостью
                        return Integer.compare(p2.capacity, p1.capacity);
                    }
                    // Меньшая заполненность
                    return Double.compare(fill1, fill2);
                })
                .map(Parking::getId)
                .orElse(-1);
    }


//    private int maxCapacity(List<Parking> parkings) {
//        return parkings.stream()
//                .max(Comparator.comparingInt(p -> p.capacity))
//                .map(p -> p.id)
//                .orElse(-1);
//    }
//
//    private int maxFreeSpaces(List<Parking> parkings, List<Car> cars) {
//        Map<Integer, Long> occupied = cars.stream()
//                .collect(Collectors.groupingBy(Car::getParkingId, Collectors.counting()));
//
//        return parkings.stream()
//                .max(Comparator.comparingInt(p -> p.capacity - occupied.getOrDefault(p.id, 0L).intValue()))
//                .map(p -> p.id)
//                .orElse(-1);
//    }

    static class Parking {
        int id;
        int capacity; //вместимость

        public Parking(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }

    static class Car {
        int id;
        int parkingId; //id парковки, на которой стоит car.id

        public Car(int id, int parkingId) {
            this.id = id;
            this.parkingId = parkingId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParkingId() {
            return parkingId;
        }

        public void setParkingId(int parkingId) {
            this.parkingId = parkingId;
        }
    }
}
