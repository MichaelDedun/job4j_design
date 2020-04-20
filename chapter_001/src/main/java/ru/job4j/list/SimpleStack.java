package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleLinkedList<T> lst = new SimpleLinkedList<>();

    public T poll() {
         return lst.deleteLast();
    }

    public void push(T value) {
        lst.add(value);
    }

}
