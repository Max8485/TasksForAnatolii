package org.example.springproject.livecode.tasks;

public class TestDynamicArray {
    public static void main(String[] args) {
        // Пример 1 из условия
        System.out.println("=== Пример 1 ===");
        DynamicArray arr1 = new DynamicArray(1);
        System.out.println("getSize(): " + arr1.getSize());        // 0
        System.out.println("getCapacity(): " + arr1.getCapacity()); // 1

        // Пример 2 из условия
        System.out.println("\n=== Пример 2 ===");
        DynamicArray arr2 = new DynamicArray(1);
        System.out.println("pushback(1)");
        arr2.pushback(1);
        System.out.println("getCapacity(): " + arr2.getCapacity()); // 1
        System.out.println("pushback(2)");
        arr2.pushback(2);
        System.out.println("getCapacity(): " + arr2.getCapacity()); // 2

        // Пример 3 из условия (сложный)
        System.out.println("\n=== Пример 3 ===");
        DynamicArray arr3 = new DynamicArray(1);

        System.out.println("getSize(): " + arr3.getSize());         // 0
        System.out.println("getCapacity(): " + arr3.getCapacity()); // 1

        System.out.println("pushback(1)");
        arr3.pushback(1);
        System.out.println("getSize(): " + arr3.getSize());         // 1
        System.out.println("getCapacity(): " + arr3.getCapacity()); // 1

        System.out.println("pushback(2)");
        arr3.pushback(2);
        System.out.println("getSize(): " + arr3.getSize());         // 2
        System.out.println("getCapacity(): " + arr3.getCapacity()); // 2

        System.out.println("get(1): " + arr3.get(1));               // 2

        System.out.println("set(1, 3)");
        arr3.set(1, 3);
        System.out.println("get(1): " + arr3.get(1));               // 3

        System.out.println("popback(): " + arr3.popback());         // 3
        System.out.println("getSize(): " + arr3.getSize());         // 1
        System.out.println("getCapacity(): " + arr3.getCapacity()); // 2
    }
}
