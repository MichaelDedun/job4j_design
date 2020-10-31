package ru.job4j.nonblockingalgorithm;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASСount {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public CASСount() {
        count.set(0);
    }

    public void increment() {
        int value;
        int newValue;
        do {
            value = count.get();
            newValue = value + 1;
        } while (!count.compareAndSet(value, newValue));
    }

    public int get() {
        return count.get();
    }

}
