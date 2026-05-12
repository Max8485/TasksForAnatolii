package org.example.springproject.livecode.tasks.Anatolii;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.example.springproject.livecode.tasks.Anatolii.FuzzySearch.fuzzySearch;

public class LiveCodeForAnatolii {
    public static void main(String[] args) {
        UserService userService = new UserService();


        Group group1 = new Group();
        group1.setName("X-Team");
        group1.setDescription("Команда - Х");

        Group group2 = new Group();
        group2.setName("Developers");

        Group group3 = new Group();
        group3.setName("X-Project");


        User user1 = new User();
        user1.setName("Иван");
        user1.setGroups(List.of(group1));

        User user2 = new User();
        user2.setName("Максим");
        user2.setGroups(List.of(group2));

        User user3 = new User();
        user3.setName("Андрей");
        user3.setGroups(List.of(group3));

        List<User> result = userService.filterUsers(Stream.of(user1, user2, user3));
        result.forEach(u -> System.out.println(u.getName()));

        ///////fuzzySearch//////
        System.out.println(fuzzySearch("car", "cardholder"));  //true
        System.out.println(fuzzySearch("car", "cwardholder")); //true
        System.out.println(fuzzySearch("car", "rac"));         //false
        System.out.println(fuzzySearch("car", "candle"));      //false

        Stream<Integer> numbers = Stream.of(7, 4, 2, 8, 9, 1, 4, 5, 8, 2);
//        System.out.println(numbers.min(Integer::compareTo).get()); //1
//        System.out.println(numbers.sorted(Collections.reverseOrder()).findFirst().get()); //9
//        System.out.println(numbers.limit(4).max(Integer::compareTo).get()); //8
//        System.out.println(numbers.distinct().skip(6).findAny().get()); //5


    }
}
