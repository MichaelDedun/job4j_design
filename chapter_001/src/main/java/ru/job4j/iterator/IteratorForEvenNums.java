package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class IteratorForEvenNums implements Iterator {
    private final int[] nums;
    private int index = 0;

    public IteratorForEvenNums(int[] nums) {
        this.nums = nums;
    }


    @Override
    public boolean hasNext() {
        return IntStream.of(nums).skip(index).anyMatch(el -> el % 2 == 0) && nums.length > index;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result = nums[i];
                index = i;
                break;
            }
        }
        index++;
        return result;
    }
}
