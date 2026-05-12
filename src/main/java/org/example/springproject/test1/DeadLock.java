package org.example.springproject.test1;

public class DeadLock {
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        // Поток 1 захватывает LOCK_1 и пытается захватить LOCK_2
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_1) {
                System.out.println("Поток 1: захватил LOCK_1");

                try {
                    Thread.sleep(100);    // Даем время Потоку 2 захватить LOCK_2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Поток 1: пытаюсь захватить LOCK_2...");
                synchronized (LOCK_2) {
                    System.out.println("Поток 1: захватил LOCK_2 (ЭТО НИКОГДА НЕ ПРОИЗОЙДЕТ)");
                }
            }
        });

        // Поток 2 захватывает LOCK_2 и пытается захватить LOCK_1
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_2) {
                System.out.println("Поток 2: захватил LOCK_2");

                try {
                    Thread.sleep(100);   // Даем время Потоку 1 захватить LOCK_1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Поток 2: пытаюсь захватить LOCK_1...");
                synchronized (LOCK_1) {
                    System.out.println("Поток 2: захватил LOCK_1 (ЭТО НИКОГДА НЕ ПРОИЗОЙДЕТ)");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
//ВЫВОД:

//Поток 1: захватил LOCK_1
//Поток 2: захватил LOCK_2
//Поток 1: пытаюсь захватить LOCK_2...
//Поток 2: пытаюсь захватить LOCK_1...

//Поток 1 захватил LOCK_1 и ждет LOCK_2
//Поток 2 захватил LOCK_2 и ждет LOCK_1
//Оба ждут друг друга вечно
