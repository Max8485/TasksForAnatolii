package org.example.springproject;

//package org.example;
//public class Main {
//    public static void main(String[] args) {
//        int[] nums = new int[] {...,...,...  ...,...};
//        System.out.println(maxProduct(nums));
//    }
//    public static int maxProduct(int[] nums) {
//// your code here
//    }
//}
//
//Реализуйте тело метода maxProduct().
//
//На входе в метод передается массив целых чисел. Длина массива может быть от 2 до 500. Числа в массиве имеют значения от 1 до 1000.
//
//Выберите два различных значения индекса массива, m и n.
//
//Найдите максимальное значение выражения (nums[m] – 1) * (nums[n] – 1). Найденное значение является возвращаемым значением метода.
//
//Выведите m и n в коде метода.
//
//Сортировку не использовать. Сложность алгоритма должна быть не более О(n).
//
//Приведите в пример пару тестовых массивов с ожидаемым результатом.

import org.example.springproject.test1.Animal;
import org.example.springproject.test1.Cat;
import org.example.springproject.test1.Dog;
import org.example.springproject.test1.Example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {  //Как передаются параметры в методы в Java? По значению!
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());

        for (Animal animal : animals) {
            animal.eat();
        }
        System.out.println(animals);




        Example example = new Example();

        //Reflection API
        Class<? extends Example> aClass = example.getClass();
        Field field = aClass.getDeclaredField("str");
        field.setAccessible(true);

        System.out.println("=== АННОТАЦИИ ПРИВАТНОГО ПОЛЯ str ===\n");

        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation);

        System.out.println();
        System.out.println("=== АННОТАЦИИ ПРИВАТНОГО ПОЛЯ str ===\n");


//        String str = (String) field.get(example);

        // через геттер
//        String str = example.getStr();
//        System.out.println("Проверяем геттер - " + str);
//        example.setStr("New Str");     // и теперь можем вызвать его в методе main а также можем менять его значение без изменений в main.
//        example.testSetter();

//В production-коде доступ к приватным полям извне - антипаттерн.
// Если вам нужно значение поля, класс должен предоставить публичный метод для его получения.

        final int[] mas = {0, 0, 0};
        anotherMethod(mas); // 1, 1, 1
        //  method(mas);  // 999, 0, 0
        System.out.println(Arrays.toString(mas));


        /////////// задача с animal ////////////////

        Animal animal = new Cat(); // Приведение вверх. Здесь создается объект класса Cat,
        // который затем автоматически приводится к типу Animal при установке в переменную animal.
        animal.eat();
        // animal.meow();
        Cat cat = (Cat) animal; // Явное приведение вниз - объект класса Animal явно приводится к типу Cat, чтобы можно было использовать методы и свойства класса Cat.
        cat.meow(); //можно так сделать

        ((Cat) animal).meow(); //или так


        /////////// задача с animal ////////////////
    }


    public static void method(int[] arr) {
        arr[0] = 999;
    }

    public static void anotherMethod(int[] arr) {
        int[] mas = {1, 1, 1};            // int[] mas = {1,1,1};
        //  arr = mas; //при данной реализации метод ничего не передает и будет 0, 0, 0
        arr[0] = mas[0];
        arr[1] = mas[1];
        arr[2] = mas[2];

        //Итог:
        //Первая версия (arr = mas): меняет куда указывает локальная переменная, не затрагивая исходный массив

        //Вторая версия (с копированием элементов): изменяет содержимое исходного массива, поэтому изменения сохраняются
    }


//        int[] nums = new int[] {1, 2, 3, 4, 10, 15, 50, 500, 333, 259, 850};
//        System.out.println(maxProduct(nums));
//
//        int[] nums1 = new int[] {1, 100, 8, 15, 19, 38, 55, 9, 87, 600, 4};
//        System.out.println(maxProduct(nums1));

//    }

//    public static int maxProduct(int[] nums) {
//        if (nums.length < 2 || nums.length > 500) {
//            throw new IllegalArgumentException("Длина массива может быть от 2 до 500");
//        }
//
//        int max1 = Integer.MIN_VALUE;
//        int max2 = Integer.MIN_VALUE;
//
//        int m = 0;
//        int n = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max1) {
//                max2 = max1;
//                n = m;
//                max1 = nums[i];
//                m = i;
//            } else if (nums[i] > max2) {
//                max2 = nums[i];
//                n = i;
//            }
//        }
//        System.out.println("m = " + m + ", n = " + n);
//
//        return (max1 - 1) * (max2 - 1);
//    }
}




