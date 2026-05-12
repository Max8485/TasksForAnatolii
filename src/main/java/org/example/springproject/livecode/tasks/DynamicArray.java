package org.example.springproject.livecode.tasks;

import java.util.Arrays;

public class DynamicArray {
    private int[] arr;      // внутренний массив для хранения элементов
    private int size;       // текущее количество элементов
    private int capacity;   // текущая ёмкость массива

    // Конструктор: инициализирует пустой массив с заданной ёмкостью
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) { // Возвращает элемент по индексу
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
        }
        return arr[i];
    }

    public void set(int i, int n) {     // Устанавливает значение n по индексу i
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + size);
        }
        arr[i] = n;
    }

    public void pushback(int n) {     // Добавляет элемент в конец массива
        if (size == capacity) {
            resize();
        }
        arr[size] = n;
        size++;
    }

    public int popback() {     // Удаляет и возвращает последний элемент
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int lastElement = arr[size - 1];
        size--;
        return lastElement;
    }

    private void resize() {     // Удваивает ёмкость массива
        capacity = capacity * 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public int getSize() {     // Возвращает текущее количество элементов
        return size;
    }

    public int getCapacity() {     // Возвращает текущую ёмкость массива
        return capacity;
    }

    // Для отладки: выводит состояние массива
    public void printState() {
        System.out.println("Size: " + size + ", Capacity: " + capacity);
        System.out.println("Array contents: " + Arrays.toString(Arrays.copyOf(arr, size)));
    }
}
