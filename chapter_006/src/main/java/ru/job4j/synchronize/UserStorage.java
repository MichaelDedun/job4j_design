package ru.job4j.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.synchronize.User;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private HashMap<Integer, User> storage = new HashMap<>();

    public synchronized boolean add(User user) {
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public synchronized boolean update(User user) {
        return storage.replace(user.getId(), storage.get(user.getId()), user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        if (storage.containsKey(fromId) && storage.containsKey(toId) && storage.get(fromId).getAmount() > amount) {
            User userFrom = storage.get(fromId);
            User userTo = storage.get(toId);
            userFrom.setAmount(userFrom.getAmount() - amount);
            userTo.setAmount(userTo.getAmount() + amount);
            storage.replace(fromId, userFrom);
            storage.replace(toId, userTo);
            return true;
        }
        return false;
    }
    
}
