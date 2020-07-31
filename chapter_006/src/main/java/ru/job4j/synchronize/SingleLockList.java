package ru.job4j.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private final SimpleLinkedList<T> list = new SimpleLinkedList();

    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }


    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    private SimpleLinkedList<T> copy(SimpleLinkedList<T> list) {
        SimpleLinkedList<T> newList = new SimpleLinkedList<>();
        list.forEach(newList::add);
        return newList;
    }

}
