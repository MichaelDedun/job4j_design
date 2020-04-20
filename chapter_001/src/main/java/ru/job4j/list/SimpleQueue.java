package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleLinkedList<T> lst = new SimpleLinkedList<>();

    public T poll() {
        return lst.deleteFirst();
    }

    public void push(T value) {
        lst.add(value);
    }

}
