package org.example.springproject.livecode.tasks.Anatolii;

import java.util.*;
public class DictionaryService { //ревью кода
    private static final int ON_PAGE = 10;  //final private int ON_PAGE = 10;
    private HashMap<Integer, String> dictionary = new HashMap<>(); //был public и не проинициализирован.
    //    public String description;
    //    public int code;
    private int nextId = 1;

    public static void main(String[] args) {
        DictionaryService service = new DictionaryService();

        // Добавляем тестовые записи
        for (int i = 1; i <= 30; i++) {
            System.out.println("Создана запись ID: " +
                    service.createDictionaryRow("Запись " + i));
        }
        // Выводим страницу
        System.out.println("Страница номер " + service.getDictionaryPage(0));
    }

    //получить страницу из справочника
    public Map<Integer, String> getDictionaryPage(int pageNumber) { //метод выводит записи со страницы по порядку (по 10 записей на 1 странице)
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Страница должна быть >= 1, а в параметры пришло: " + pageNumber);
        }

        Map<Integer, String> dictionaryPage = new LinkedHashMap<>();

        List<Integer> sortedKeys = new ArrayList<>(dictionary.keySet());
        Collections.sort(sortedKeys);

        int startIndex = (pageNumber - 1) * ON_PAGE;

        for (int i = 0; i < ON_PAGE; i++) {
            int index = startIndex + i;
            if (index >= sortedKeys.size()) {
                break;
            }
            Integer key = sortedKeys.get(index);

            dictionaryPage.put(key, dictionary.get(key));
        }
        return dictionaryPage;
    }

//    public HashMap<String, String> getDictionaryPage(int pageNumber) {
//        HashMap<String, String> dictionaryPage = new HashMap<>();
//
//        Set<String> dictionaryKeys = dictionary.keySet();
//
//        for (int i = 0; i < ON_PAGE; i++) {
//            String dictionaryKey = dictionaryKeys[i + (pageNumber –1) *ON_PAGE];
//
//            dictionaryPage.put(dictionaryKey, dictionary.get(dictionaryKey));
//        }
//
//        return dictionaryPage;
//    }

    //создать запись в справочнике
    public int createDictionaryRow(String description) {
        int newId = nextId++;
        dictionary.put(newId, description);

        return newId;
    }

//    public void createDictionaryRow(String a, String b) {
//        code = a;
//        description = b;
//
//        dictionary.put(a, b);
//    }
}
