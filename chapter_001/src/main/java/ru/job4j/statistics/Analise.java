package ru.job4j.statistics;

import java.util.*;

public class Analise {

    public static Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        Map<Integer, User> users = new HashMap<>();
        for (User user : previous) {
            users.put(user.id, user);
        }
        for (User user : current) {
            if (users.containsKey(user.id) && !users.get(user.id).equals(user))
                changed++;
            else if (!users.containsKey(user.id))
                added++;
        }
        deleted = previous.size() - (current.size() - added);
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }

    Comparator<User> compById = Comparator.comparingInt(left -> left.id);

    public static class Info {
        int added;
        int changed;
        int deleted;

        Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

    }

}