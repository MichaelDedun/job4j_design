package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<V> {
    private Object[] table;
    private int capacity = 16;
    private float loadFactor;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size = 0;
    private int modCount = 0;

    public SimpleMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Node[capacity];
    }

    public SimpleMap(int capacity) {
        this.capacity = capacity;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Node[capacity];
    }

    public SimpleMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
    }

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);
        if (table[index] == null) {
            throw new NoSuchElementException();
        }
        return ((Node<K, V>) table[index]).value;
    }

    public boolean put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);
        int threshold = (int) (capacity * loadFactor);
        if (table[index] != null) {
            return false;
        }
        if (threshold == size) {
            table = expansionContainer();
        }
        Node<K, V> el = new Node<>(hash, key, value);
        table[index] = el;
        size++;
        modCount++;
        return true;
    }

    public boolean delete(K key) {
        int hash = hash(key);
        int index = indexFor(hash, capacity);
        if (table[index] == null) {
            return false;
        }
        table[index] = null;
        modCount++;
        return true;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Object[] expansionContainer() {
        Object[] newTable = new Object[capacity];
        capacity *= 2;
        for (Object el : table) {
            if (el != null) {
                Node<K, V> node = (Node<K, V>) el;
                int newHash = hash(node.key);
                int newIndex = indexFor(newHash, capacity);
                newTable[newIndex] = el;
            }
        }
        return newTable;
    }

    private static class Node<K, V> {
        int hash;
        K key;
        V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int valuesCounter = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return valuesCounter <= size;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (table[valuesCounter] == null) {
                    valuesCounter++;
                }
                return ((Node<K, V>) table[valuesCounter]).value;
            }

        };

    }

}
