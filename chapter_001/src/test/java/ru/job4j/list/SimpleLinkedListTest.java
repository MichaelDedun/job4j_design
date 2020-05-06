package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListTest {

    @Test
    public void testAdd() {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(3, (int) linkedList.get(2));
        Assert.assertEquals(4, (int) linkedList.get(3));
        Assert.assertEquals(5, (int) linkedList.get(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.add("first");
        Iterator<String> it = linkedList.iterator();
        linkedList.add("second");
        it.next();
    }

    @Test
    public void testIterator() {
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");
        linkedList.add("fourth");
        Iterator<String> it = linkedList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("first"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("second"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("third"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("fourth"));
        assertThat(it.hasNext(), is(false));
    }

}