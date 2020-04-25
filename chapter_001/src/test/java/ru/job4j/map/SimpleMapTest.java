package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

public class SimpleMapTest {

    @Test
    public void testPut() {
        SimpleMap<Integer,String> map = new SimpleMap<>();
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);
        map.put(6, null);
        map.put(7, null);
        map.put(8, null);
        map.put(9, null);
        map.put(10, null);
        map.put(11, null);
        map.put(12, null);
        map.put(13, null);
        boolean result = map.put(12, "Ygy");
        Assert.assertFalse(result);
    }

    @Test
    public void testDelete() {
        SimpleMap<Integer,String> map = new SimpleMap<>();
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");
        boolean result = map.delete(1);
        Assert.assertTrue(result);
    }

    @Test
    public void testGet() {
        SimpleMap<Integer,String> map = new SimpleMap<>();
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");
        Assert.assertEquals("test", map.get(1));
    }

}