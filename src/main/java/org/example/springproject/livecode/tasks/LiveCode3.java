package org.example.springproject.livecode.tasks;

public class LiveCode3 {
    public static void main(String[] args) {
        LiveCode3 liveCode3 = new LiveCode3();

        // Задача 1.1: Палиндром
        System.out.println(liveCode3.isPalindrome("Was it a car or a cat I sawqq?"));

    }
    // СТРОКИ:

    // Задача 1.1: Палиндром

    // Проверить, является ли строка палиндромом (читается одинаково слева направо и справа налево), игнорируя:
    // Регистр букв (A = a)
    // Небуквенные символы (пробелы, знаки препинания и т.д.)

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Получаем символы и приводим к нижнему регистру
            char leftChar = Character.toLowerCase(str.charAt(left));
            char rightChar = Character.toLowerCase(str.charAt(right));

            // Пропускаем небуквенные символы слева
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            // Пропускаем небуквенные символы справа
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            // Сравниваем символы
            else if (leftChar != rightChar) {
                return false;  // найдено несовпадение → не палиндром
            }
            // Символы равны → двигаем оба указателя
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
