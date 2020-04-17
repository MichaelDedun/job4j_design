package ru.job4j.generic;

import java.util.Iterator;

public class SimplyArray<T> implements Iterable<T>{
    private Object[] array;
    private int index = 0;
    private int size;

    public SimplyArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public void add(T model) {
        array[index++] = model;
    }

    public void set(int position, T model) {
        array[position] = model;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[array.length-1] = null;
        size--;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimplyArrayIterator(array);
    }

}
