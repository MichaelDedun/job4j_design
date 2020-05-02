package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void testPut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
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
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");
        boolean result = map.delete(1);
        Assert.assertTrue(result);
    }

    @Test
    public void testGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");
        Assert.assertEquals("test", map.get(1));
    }

    @Test
    public void testIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "privet");
        map.put(2, "privet");
        map.put(3, "privet");
        map.put(4, "privet");
        map.put(5, "privet");
        map.put(6, "privet");
        map.put(7, "privet");
        map.put(8, "privet");
        map.put(9, "privet");
        map.put(10, "privet");
        map.put(11, "privet");
        map.put(12, "privet");
        map.put(13, "privet");
        Iterator<String> it = map.iterator();
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("privet"));
        assertThat(it.hasNext(), is(true));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "first");
        Iterator<String> it = map.iterator();
        map.put(2, "second");
        it.next();
    }

}