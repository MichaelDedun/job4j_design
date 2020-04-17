package ru.job4j.generic;

import java.util.Iterator;

public class SimplyArrayIterator<T> implements Iterator {
    private final T[] array;
    private int index = 0;

    public SimplyArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public T next() {
        return (T) array[index++];
    }
}
