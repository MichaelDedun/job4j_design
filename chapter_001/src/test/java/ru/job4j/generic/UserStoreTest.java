package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;

public class UserStoreTest {

    @Test
    public void testAdd() {
        User user = new User("123");
        Store<User> store = new MemStore<>();
        store.add(user);
        Assert.assertEquals(user, store.findById("123"));
    }

    @Test
    public void testReplace() {
        User user = new User("123");
        User userForReplace = new User("543");
        Store<User> store = new MemStore<>();
        store.add(user);
        store.replace("123", userForReplace);
        Assert.assertEquals(userForReplace, store.findById("543"));
    }


    @Test
    public void testRemove() {
        User user = new User("123");
        Store<User> store = new MemStore<>();
        store.delete("123");
        Assert.assertNull(store.findById("123"));
    }

}