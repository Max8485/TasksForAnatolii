package org.example.springproject.livecode.tasks.Anatolii;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) { //в итоге у нас выводятся все нечетные числа (включая отрицательные) с паузами
        Arrays.asList(-3, 2, 1, 4, 7, 0)
                .stream()
                .filter(Task4::isOdd)
                .map(item -> {
                            int napPeriod = ThreadLocalRandom.current().nextInt(10);
                            try {
                                Thread.sleep(1000L * napPeriod);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                            }
                            return item + " " + Thread.currentThread().getName() + " nap " + napPeriod;
                        }
                )
                .forEach(System.out::println);

//        Arrays.asList(-3, 2, 1, 4, 7, 0)
//                .parallelStream()  //просто stream(), parallelStream излишен на маленьком объеме данных
//                .filter(Task4::isOdd)
//                .mapToDouble(item -> {            //должен быть map()
//                            int napPeriod = new Random().nextInt(100); //Random создается на каждый элемент - неэффективно.
//                            //Создать один static final Random или использовать ThreadLocalRandom.
//
//                            Thread.sleep(1000L * napPeriod); //обернуть в try catch
//                            return item + ")" + Thread.currentThread().getName() + "nap " + napPeriod; //немного исправили вывод
//                            //ожидает double, а возвращает String
//                        }
//                )
//                .forEach(System.out::println) //терминальный метод, на нем поток закрывается
//                .collectors(Collectors.toList()); //лишний терминальный метод и должен быть collect(Collectors.toList())
    }

    public static boolean isOdd(int number) { //добавили static
        return number % 2 != 0; // number % 2 == 1 находит только нечетные положительные числа.
        // Надо, чтобы и отрицательные проверял: number % 2 != 0;
    }
}
