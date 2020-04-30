package ru.job4j.statistics;

import java.util.Comparator;
import java.util.List;

public class Analise {


    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        previous.sort(compById);
        current.sort(compById);
        for (User user : current) {
            int i = 0;
            while (i < previous.size() - 1 && previous.get(i).id < user.id) i++;
            if (i == previous.size() - 1) {
                added++;
            } else if (user.id == previous.get(i).id && !previous.get(i).name.equals(user.name)) {
                changed++;
            } else {
                deleted++;
            }

        }
        return new Info(added, changed, deleted);

    }

    public static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
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