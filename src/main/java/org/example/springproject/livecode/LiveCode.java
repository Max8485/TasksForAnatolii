package org.example.springproject.livecode;

import org.example.springproject.livecode.tasks.Student;
import org.example.springproject.livecode.tasks.Transaction;
import org.example.springproject.livecode.tasks.Type;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class LiveCode {
    public static void main(String[] args) {
        //Уровень 1: Базовый (Lambda)

        // 1. Дан список строк. Отсортировать его по длине строки (от коротких к длинным) с использованием лямбда-выражения.
        List<String> words = Arrays.asList("Java", "Python", "C", "JavaScript", "Go");
        // Ожидаемый результат: ["C", "Go", "Java", "Python", "JavaScript"]
        words.sort((w1, w2) -> Integer.compare(w1.length(), w2.length()));
        System.out.println(words);

        //  2. - Runnable
        //Создать лямбда-выражение для Runnable, которое выводит "Hello, Lambda!" в консоль. Запустить в отдельном потоке.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello, Lambda"));
        executor.shutdown(); //shutdown() инициирует плавное завершение работы ExecutorService.
                            // Он больше не принимает новые задачи, но дает время выполниться уже отправленным задачам.

        // 3. - Фильтрация
        //Дан список целых чисел. Используя лямбду, отфильтровать и вывести только четные числа.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Ожидаемый результат: 2, 4, 6, 8, 10
        List<Integer> list = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(list);


        System.out.println("-------------------Stream API -----------------");
        //Уровень 2: Stream API

        //  4. - Преобразование списка
      //  Дан список строк. Преобразовать каждую строку в верхний регистр и собрать в новый список.
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
     // Ожидаемый результат: ["APPLE", "BANANA", "ORANGE", "GRAPE"]

        List<String> listUp = fruits.stream().map(f -> f.toUpperCase()).toList();
        System.out.println(listUp);

      //   5. - Фильтрация и сумма
       // Дан список целых чисел. Найти сумму всех чисел, которые больше 10.
        List<Integer> num = Arrays.asList(5, 12, 8, 15, 3, 20, 7);
      // Ожидаемый результат: 47 (12 + 15 + 20)

        int sum = num.stream().filter(n -> n > 10)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);


        //    6. - Поиск максимального
      //  Дан список дробных чисел. Найти максимальное значение с помощью Stream API.
        List<Double> decimals = Arrays.asList(3.14, 2.71, 1.41, 1.73, 2.23);
     // Ожидаемый результат: 3.14

        Double max = decimals.stream().max(Double::compareTo).orElse(0.0);
        System.out.println(max);


      //   7.- Удаление дубликатов
      //  Дан список с повторяющимися элементами. Получить список уникальных элементов.
        List<Integer> duplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3);
      // Ожидаемый результат: [1, 2, 3, 4, 5]

        List<Integer> list1 = duplicates.stream().distinct().toList();
        System.out.println(list1);



        System.out.println("-------------------Продвинутый Stream API -----------------");
        //Уровень 3: Продвинутый (Stream API)

        // 8. - Работа с объектами
        //Дан список студентов с полями name, grade. Собрать в список имена студентов с оценкой выше 80.
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 72),
                new Student("Charlie", 90),
                new Student("Diana", 68)
        );
             // Ожидаемый результат: ["Alice", "Charlie"]
        List<String> sdudentList = students.stream().filter(s -> s.getGrade() > 80)
                .map(Student::getName)
                .toList();
        System.out.println(sdudentList);

        // 9. - Сортировка и лимит
       // Дан список чисел. Отсортировать по убыванию и взять первые 3 элемента.
        List<Integer> n = Arrays.asList(7, 3, 9, 2, 10, 5, 8);
      // Ожидаемый результат: [10, 9, 8]
        List<Integer> integers = n.stream().sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(integers);

       //  10. - Группировка
       //   Дан список строк. Сгруппировать их по длине строки с помощью Collectors.groupingBy.
        List<String> word = Arrays.asList("cat", "dog", "elephant", "bee", "tiger", "ant");
      // Ожидаемый результат:
      // 3: ["cat", "dog", "bee", "ant"]
      // 5: ["tiger"]
      // 8: ["elephant"]
        Map<Integer, List<String>> collect = word.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);

        //  11.- FlatMap
       //  Дан список списков. Собрать все элементы в один плоский список.
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        // Ожидаемый результат: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        List<Integer> integers1 = nestedList.stream().flatMap(List::stream).toList();
        System.out.println(integers1);



        System.out.println("-------------------Hard задача для Stream API -----------------");
          //  12. - Среднее значение с маппингом
          // Дан список транзакций. Рассчитать среднюю сумму транзакций для каждого типа (Type) и вывести результат в консоль.
        List<Transaction> transactions = Arrays.asList(
                new Transaction(Type.GROCERY, 150.0, "2024-01-01"),
                new Transaction(Type.ELECTRONICS, 1200.0, "2024-01-02"),
                new Transaction(Type.GROCERY, 200.0, "2024-01-03"),
                new Transaction(Type.CLOTHING, 300.0, "2024-01-04"),
                new Transaction(Type.ELECTRONICS, 800.0, "2024-01-05")
        );
        // Ожидаемый результат:
        // GROCERY: 175.0
        // ELECTRONICS: 1000.0
        // CLOTHING: 300.0
        Map<Type, Double> result = transactions.stream().collect(Collectors.groupingBy(Transaction::getType,
                Collectors.averagingDouble(Transaction::getAmount)));
        System.out.println(result);

        //  13. Фильтрация и маппинг//Дан список чисел. Отфильтровать числа, которые делятся на 3, возвести их в квадрат и собрать в новый список.
        List<Integer> number2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15);
        // Ожидаемый результат: [9, 36, 81, 144, 225]    (3², 6², 9², 12², 15²)

        List<Integer> newList = number2.stream()
                .filter(number -> number % 3 == 0)
                .map(number -> number * number)
                .toList();

        System.out.println(number2);
        System.out.println("Результат (числа, кратные 3, в квадрате): " + newList);
    }
}
