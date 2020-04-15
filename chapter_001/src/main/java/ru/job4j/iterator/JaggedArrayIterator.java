package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator {
    private final int[][] jaggedArray;
    private int columnIndex = 0;
    private int rowIndex = 0;

    public JaggedArrayIterator(final int[][] jaggedArray) {
        this.jaggedArray = jaggedArray;
    }

    @Override
    public boolean hasNext() {
        return jaggedArray.length > rowIndex && jaggedArray[rowIndex].length > columnIndex;
    }

    @Override
    public Object next() {
        int result = jaggedArray[rowIndex][columnIndex++];
        if (columnIndex == jaggedArray[rowIndex].length) {
            rowIndex++;
            columnIndex = 0;
        }
        return result;
    }

}
