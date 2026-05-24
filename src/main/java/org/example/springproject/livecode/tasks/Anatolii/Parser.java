package org.example.springproject.livecode.tasks.Anatolii;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();

        // 1. Создаем тестовый файл
        File testFile = new File("test.txt");
        parser.setFile(testFile);

        // 2. Сохраняем текст в файл
        String originalText = "Hello World! Привет Мир! 123";
        System.out.println("Сохраняем в файл: " + originalText);
        parser.saveContent(originalText);

        // 3. Читаем весь файл
        System.out.println("\nЧитаем весь файл: " + parser.getContent());

        // 4. Читаем только ASCII символы
        System.out.println("\nЧитаем только ASCII: " + parser.getContentWithoutUnicode());

        // 5. Показываем путь к файлу
        System.out.println("\nПуть к файлу: " + testFile.getAbsolutePath());
    }

    private File file;

    public synchronized File getFile() {
        return file;
    }

    public synchronized void setFile(File file) {
        this.file = file;                              //не было this
    }

    public String getContent() throws IOException {
        try (FileInputStream input = new FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
            StringBuilder output = new StringBuilder();
            int data;

            while ((data = reader.read()) != -1) {
                output.append((char) data);
            }
            return output.toString();
        }
    }

//        public String getContent() throws IOException{
//        FileInputStream input = new FileInputStream(file);  // Ресурсы не закрываются
//        String output = "";
//        int data;
//
//        while ((data = input.read()) > 0) {                    //read() возвращает -1 при достижении конца файла
//                output = output + (char) data;            //для конкатенации строк нужен stringBuilder
//        }
//        return output;
//    }

    public String getContentWithoutUnicode() throws IOException {
        try (FileInputStream input = new FileInputStream(file); // читает байты
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) { // превращает байты в символы. Это decorator
            StringBuilder output = new StringBuilder();
            int data;

            while ((data = reader.read()) != -1) {
                if (data < 0x80) {  //Оставляет только ASCII символы
                    output.append((char) data);
                }
            }
            return output.toString();
        }
    }

//    public String getContentWithUnicode() throws IOException{
//        FileInputStream input = new FileInputStream(file);  // Ресурсы не закрываются
//        String output = "";
//        int data;
//
//        while ((data = input.read()) > 0) {   //read() возвращает -1 при достижении конца файла
//            if (data < 0x80) {
//                output = output + (char) data;    //для конкатенации строк нужен stringBuilder
//            }
//        }
//        return output;
//    }

    public void saveContent(String content) {
        try (FileOutputStream output = new FileOutputStream(file);
             OutputStreamWriter writer = new OutputStreamWriter(output, StandardCharsets.UTF_8)) { //сделали try with resources и добавили OutputStreamWriter
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void saveContent(String content) {
//        FileOutputStream output = new FileOutputStream(file); // нет try with resources
//        try {
//            for (int i = 0; i < content.length(); i++) {
//                output.write(content.charAt(i));      // не указана кодировка
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
