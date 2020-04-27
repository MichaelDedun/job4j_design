package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;
    private int modCount = 0;

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
            last = first;
        } else if (first.next == null) {
            Node<T> node = new Node<>(value, null, first);
            first.next = node;
            last = node;
        } else {
            Node<T> node = new Node<>(value, null, last);
            last.next = node;
            last = node;
        }
        modCount++;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (i == index)
                return node.value;
            node = node.next;
        }
        return null;
    }

    public T deleteLast() {
        Node<T> result;
        checkSize();
        if (size == 1) {
            result = last;
            first = null;
            last = null;
        } else {
            result = last;
            last = last.prev;
            last.next = null;
        }
        size--;
        modCount++;
        return result.value;
    }

    public T deleteFirst() {
        Node<T> result;
        checkSize();
        if (size == 1) {
            result = first;
            first = null;
            last = null;
        } else {
            result = first;
            first = first.next;
            first.prev = null;
        }
        size--;
        modCount++;
        return result.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    public void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int index = 0;
            private Node<T> current = first;
            Node<T> lastReturned;

            @Override
            public boolean hasNext() {
                return size > index;
            }

            @Override
            public T next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                lastReturned = current;
                current = current.next;
                index++;
                return lastReturned.value;
            }

        };
    }

}
