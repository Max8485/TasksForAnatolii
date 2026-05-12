package org.example.springproject.livecode.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LiveCode1 {
    public static void main(String[] args) {
        //1. Дан список строк. Найти первую строку, которая начинается с буквы "b" и длиннее 3 символов.
        List<String> strings = Arrays.asList("apple", "bat", "ball", "cat", "banana", "blue", "bee");
        Optional<String> result = strings.stream()
                .filter(s -> s.startsWith("b"))
                .filter(s -> s.length() > 3)
                .findFirst();

        if (result.isPresent()) {
            System.out.println("Найдена строка: " + result.get());
        } else {
            System.out.println("Строка не найдена");
        }


        // 2. Проверка условий (allMatch, anyMatch, noneMatch)
        //Дан список чисел. Проверить://Все ли числа положительные?//Есть ли хотя бы одно число, кратное 7? //Нет ли числа 666?
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 14, 7, 8, 666);//Ожидаемый результат: allPositive: true//
        // hasMultipleOf7: true//noEvilNumber: true

        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Все ли числа положительные? " + allMatch);

        boolean anyMatch = numbers.stream().anyMatch(n -> n % 7 == 0);
        System.out.println("Есть ли хотя бы одно число, кратное 7? " + anyMatch);

        boolean noneMatch = numbers.stream().noneMatch(n -> n == 666);
        System.out.println("Нет ли числа 666? " + noneMatch);

        ///// 3. Найти максимальный элемент в массиве///////
        System.out.println(findMax(new int[]{1, 5, 70, 555}));

        //////4. Написать метод, который переворачивает строку.//////
        String input = "Hello World";
        System.out.println(reverseString(input)); // "dlroW olleH"

        //// 5. Удалить дубликаты из отсортированного массива/////
        System.out.println(Arrays.toString(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})));

        ////////6. Объединение двух отсортированных массивов///////
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(merge(arr1, arr2)));

        //////7. Фильтрация и преобразование ///////
        List<String> list = Arrays.asList("cat", "elephant", "dog", "tiger", "bird", "bear");
        filterStr(list);

        //////8. Группировка и подсчет////////
        List<String> groupList = Arrays.asList("apple", "cat", "apricot", "car", "banana", "dog", "ant");
        groupStr(groupList);

        ///////9. Найти сумму квадратов всех четных чисел.//////
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); //220
        sum(integers);

        /////10. Разделить числа на положительные и отрицательные группы
        List<Integer> partInt = Arrays.asList(-5, 3, -2, 8, -1, 0, 6, -4, 9);
        partitioning(partInt);

        //11. Найти все палиндромы (слова, которые читаются одинаково с начала и конца).
        palindrome((Arrays.asList("level", "java", "radar", "python", "madam", "hello")));

    }

    ////////3. Максимальный элемент в массиве////////////////
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //////4. Написать метод, который переворачивает строку.//////
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    //// 5. Удалить дубликаты из отсортированного массива и вернуть новый массив/////
    public static int[] removeDuplicates(int[] nums) { //   int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        if (nums.length == 0) return new int[0];

        int uniqueCount = 0; // подсчет уникальных элементов
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                uniqueCount++;
            }
        }
        // Заполнение результата
        int[] result = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                result[index++] = nums[i];
            }
        }
        return result;
    }

    /////6. Объединение двух отсортированных массивов///////
    public static int[] merge(int[] arr1, int[] arr2) {    //arr1: [1, 3, 5, 7]  // arr2: [2, 4, 6, 8]
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        // Сравниваем и вставляем меньший элемент
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        // Копируем оставшиеся элементы
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    //7. Фильтрация и преобразование - Дан список строк. Отфильтровать строки длиннее 3 символов,
    // преобразовать в верхний регистр и отсортировать.
    public static void filterStr(List<String> strList) { // "cat", "elephant", "dog", "tiger", "bird", "bear"
        List<String> list = strList.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println(list);
    }

    //////8. Группировка и подсчет
    //Условие: Дан список строк. Сгруппировать их по первой букве и подсчитать количество в каждой группе.
    public static void groupStr(List<String> list) { //"apple", "cat", "apricot", "car", "banana", "dog", "ant"
        Map<Character, Long> collect = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println(collect);
    }

    ////////9. Арифметические операции
    //Условие: Дан список чисел. Найти сумму квадратов всех четных чисел.
    public static void sum(List<Integer> list) {
        Integer reduce = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    ///////10. Partitioning (разделение на две группы)
    //Условие: Разделить числа на положительные и отрицательные.
    public static void partitioning(List<Integer> list) {
        Map<Boolean, List<Integer>> result = list.stream()
                .filter(n -> n != 0)
                .collect(Collectors.partitioningBy(n -> n > 0));

        System.out.println("Положительные: " + result.get(true));
        System.out.println("Отрицательные: " + result.get(false));
    }

    /////11. Найти все палиндромы (слова, которые читаются одинаково с начала и конца).
    public static void palindrome(List<String> words) {
        // Ожидаемый результат: [level, radar, madam]
        List<String> list = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .toList();
        System.out.println(list);
    }


}
