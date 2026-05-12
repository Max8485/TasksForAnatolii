package org.example.springproject.patterns.singleton;

public class SynchronizedSingleton {
    private static volatile SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {

    }

    public static SynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (SynchronizedSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SynchronizedSingleton();
                }
            }
        }
        return INSTANCE;
    }

    // Добавьте хотя бы один нестатический метод
    public void doSomething() {
        System.out.println("Singleton is working");
    }
}
