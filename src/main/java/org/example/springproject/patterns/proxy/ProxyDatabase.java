package org.example.springproject.patterns.proxy;

public class ProxyDatabase implements DatabaseQuery{ //Прокси (ленивая инициализация)
    private HeavyDatabaseService realService;

    @Override
    public String execute(String sql) {
        // Ленивая инициализация - только при первом вызове
        if (realService == null) {
            System.out.println("Первый вызов - создаём реальный сервис");
            realService = new HeavyDatabaseService();
        }
        System.out.println("Прокси вызывает реальный метод");
        return realService.execute(sql);
    }
}
