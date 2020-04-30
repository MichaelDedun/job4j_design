package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T> implements Iterable<T> {
    private Node<T> first = new Node<>();
    private Node<T> last = new Node<>();
    private int size = 0;
    private int modCount = 0;

    public SimpleLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public T get(int index) {
        Objects.checkIndex(index,size);
        Node<T> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        node.next = last.prev.next;
        last.prev.next = node;
        last.prev = node;
        modCount++;
        size++;
    }

    public T deleteLast() {
        checkSize();
        T value = last.prev.value;
        last.prev = last.prev.prev;
        modCount++;
        size--;
        return value;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
        modCount++;
        size++;
    }

    public T deleteFirst() {
        checkSize();
        T value = first.next.value;
        first.next = first.next.next;
        modCount++;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int index = 0;
            private Node<T> current = first.next;
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
