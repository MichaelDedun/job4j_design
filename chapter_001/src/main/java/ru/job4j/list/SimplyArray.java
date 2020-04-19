package ru.job4j.list;

import java.util.*;

public class SimplyArray<T> implements Iterable<T> {
    private Object[] container;
    private int capacity = 1;
    private int index = 0;
    private int modCount = 0;

    public SimplyArray() {
        this.container = new Object[capacity];
    }

    public T get(int index) {
        try {
            Objects.checkIndex(index, container.length - index);
            return (T) container[index];
        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }

    public void add(T model) {
        if (index >= capacity) {
            capacity = capacity * 2;
            container = Arrays.copyOf(container, capacity);
            container[index++] = model;
            modCount++;
        } else {
            container[index++] = model;
            modCount++;
        }
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
                if (!hasNext()) {
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
