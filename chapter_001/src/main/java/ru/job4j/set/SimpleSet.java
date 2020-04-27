package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> lst = new SimpleArray<>();

    public void add(T model) {
        if (!lst.contains(model)) {
            lst.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return lst.iterator();
    }

}

