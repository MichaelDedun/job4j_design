package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimplyArrayIterator<T> implements Iterator<T> {
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
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) array[index++];
    }
}
