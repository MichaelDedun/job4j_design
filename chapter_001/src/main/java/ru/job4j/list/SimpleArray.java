package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int capacity = 1;
    private int position = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[capacity];
    }

    public T get(int index) {
        try {
            Objects.checkIndex(index, position);
            return (T) container[index];
        } catch (Exception ex) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(T model) {
        if (position >= capacity) {
            capacity = capacity * 2;
            container = Arrays.copyOf(container, capacity);
            container[position] = model;
        } else {
            container[position] = model;
        }
        position++;
        modCount++;
    }

    public boolean contains(T model) {
            for (Object el : container) {
                if (el == model) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return position > index;
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
