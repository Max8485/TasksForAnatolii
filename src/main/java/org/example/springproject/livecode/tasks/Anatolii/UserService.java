package org.example.springproject.livecode.tasks.Anatolii;

import java.util.List;
import java.util.stream.Stream;

public class UserService {
    // @Data
    //class User {
    //    private String name;
    //    private String surname;
    //    private List<Group> groups;
    //}

    // @Data
    //class Group {
    //    private String name;
    //    private String description;
    //}

    // вернуть список юзеров, у которых название группы начинается на "Х"
    public List<User> filterUsers(Stream<User> users) {
        return users.filter(u -> u.getGroups()
                        .stream()
                        .anyMatch(g -> g.getName().startsWith("X")))
                    .toList();
    }

}
