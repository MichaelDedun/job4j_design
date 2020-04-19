package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForEvenNums implements Iterator {
    private final int[] nums;
    private int index = 0;

    public IteratorForEvenNums(int[] nums) {
        this.nums = nums;
    }


    @Override
    public boolean hasNext() {
        for(int i = index; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                index = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return nums[index++];
    }
}
