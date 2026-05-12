package org.example.springproject.patterns.proxy;

public class HeavyDatabaseService implements DatabaseQuery { //Реальный объект (тяжёлый)
    public HeavyDatabaseService() {
        System.out.println("Загрузка драйверов, подключение к БД, инициализация пула соединений...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        } // эмуляция тяжелой инициализации
    }

    @Override
    public String execute(String sql) {
        return "Результат запроса: " + sql;
    }
}
