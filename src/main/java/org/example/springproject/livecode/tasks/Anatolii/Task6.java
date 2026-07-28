package org.example.springproject.livecode.tasks.Anatolii;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(compressString("AAaaabCCc"));

    }

    //- На вход дана строка типа "AAaaabCCcc", реализовать метод, скукоживающий ее до  "A2a3bC2c2";
    //- Реализовать дедлок;
    //- Напрограммировать race condition.
    //
    //Что-то напоминает, не правда ли?


    //- На вход дана строка типа "AAaaabCCcc", реализовать метод, скукоживающий ее до  "A2a3bC2c2";
    public static String compressString(String str) {
        int count = 1;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    }

    //// Ключевая идея: считать, пока символы одинаковые
    //if (текущий == следующий) {
    //    count++;           // увеличиваем счетчик
    //} else {
    //    записать(символ);  // выводим символ
    //    if (count > 1) {
    //        записать(count);  // выводим количество (если >1)
    //    }
    //    count = 1;         // сбрасываем для следующей группы
    //}


}
