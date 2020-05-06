package ru.job4j.iterator;

import java.util.*;

class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Iterator<Integer>> external = it;
            private Iterator<Integer> current = it == null ? Collections.emptyIterator() : it.next();

            @Override
            public boolean hasNext() {
                while (!current.hasNext() && external.hasNext())
                    current = external.next();
                return current.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }

}
