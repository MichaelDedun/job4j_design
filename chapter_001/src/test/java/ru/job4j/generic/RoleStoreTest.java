package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Test;

public class RoleStoreTest {

    @Test
    public void testAdd() {
        Role role = new Role("123", "test");
        Store<User> store = new MemStore<>();
        store.add(role);
        Assert.assertEquals(role, store.findById("123"));
    }

    @Test
    public void testReplace() {
        Role role = new Role("123", "test");
        Role roleForReplace = new Role("543", "test2");
        Store<Role> store = new MemStore<>();
        store.add(role);
        store.replace("123", roleForReplace);
        Assert.assertEquals(roleForReplace, store.findById("543"));
    }


    @Test
    public void testRemove() {
        Role role = new Role("123","test");
        Store<Role> store = new MemStore<>();
        store.delete("123");
        Assert.assertNull(store.findById("123"));
    }

}
