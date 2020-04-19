package ru.job4j.generic;

public class Role extends User {
    private String role;

    public Role(String id, String role) {
        super(id);
        this.role = role;
    }

}
