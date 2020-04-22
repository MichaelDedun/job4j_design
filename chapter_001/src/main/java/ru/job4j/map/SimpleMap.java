package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class SimpleMap {

    public static void main(String[] args) {
        User user = new User("Vova", 2, new GregorianCalendar(2017, 1, 25));
        User user1 = new User("Vova", 2, new GregorianCalendar(2017, 1, 25));
        Map<User,Object> users = new HashMap<>();
        users.put(user,user);
        users.put(user1,user1);
        for (Map.Entry<User, Object> el: users.entrySet()) {
            System.out.println("Ключ " + el.getKey() + "Значение " + el.getValue());
        }
    }

}
