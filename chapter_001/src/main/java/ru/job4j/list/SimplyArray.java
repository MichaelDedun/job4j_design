package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimplyArray<T> implements Iterable<T> {
    private Object[] container;
    private int capacity = 1;
    private int index = 0;
    private int modCount = 0;

    public SimplyArray() {
        this.container = new Object[capacity];
    }

    public T get(int index) {
        if (index >= capacity || container[index] == null) {
            throw new NoSuchElementException();
        }
        return (T) container[index];
    }

    public void add(T model) {
        if (index == capacity) {
            container = Arrays.copyOf(container, capacity*2);
            container[index++] = model;
            modCount++;
        }
        container[index] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return container.length > index;
            }

            @Override
            public T next() {
                if (!hasNext() || container[index] == null){
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[index++];
            }
        };
    }

}
