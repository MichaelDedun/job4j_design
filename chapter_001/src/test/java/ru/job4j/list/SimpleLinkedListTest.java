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
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        Assert.assertEquals(1, (int) linkedList.get(0));
        Assert.assertEquals(2, (int) linkedList.get(1));
        Assert.assertEquals(3, (int) linkedList.get(2));
        Assert.assertEquals(4, (int) linkedList.get(3));
        Assert.assertEquals(5, (int) linkedList.get(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.addLast("first");
        Iterator<String> it = linkedList.iterator();
        linkedList.addLast("second");
        it.next();
    }

    @Test
    public void testIterator() {
        SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
        linkedList.addLast("first");
        linkedList.addLast("second");
        linkedList.addLast("third");
        linkedList.addLast("fourth");
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