package org.example.springproject.livecode.tasks.Anatolii;

public class FuzzySearch {
    //написать функцию FuzzySearch, которая осуществляет неточный поиск и определяет вхождения символов одной строки
    // в другую с учетом порядка.

    //пример:
    //fuzzySearch("car", "cardholder") //true
    //fuzzySearch("car", "cwardholder") //true
    //fuzzySearch("car", "rac") //false
    //fuzzySearch("car", "candle") //false

    public static boolean fuzzySearch(String word, String phrase) {
        int searchIndex = 0;

        for (int i = 0; i < phrase.length() && searchIndex < word.length(); i++) {
            if (phrase.charAt(i) == word.charAt(searchIndex)) {
                searchIndex++;
            }
        }
        return searchIndex == word.length();
    }
}

//Бежим по тексту и ищем символы поисковой строки по порядку, переходя к следующему только когда нашли текущий.

//Запомните паттерн: это классический алгоритм "двух указателей" для проверки,
// является ли одна строка подпоследовательностью (subsequence) другой!