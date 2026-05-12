package org.example.springproject.livecode.tasks.Anatolii;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private String surname;
    private List<Group> groups;
}
