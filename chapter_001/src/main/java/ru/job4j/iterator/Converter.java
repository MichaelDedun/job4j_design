package ru.job4j.iterator;

import java.util.Iterator;

class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Iterator<Integer>> external = it;
            private Iterator<Integer> current = it.next();

            @Override
            public boolean hasNext() {
                while (!current.hasNext() && external.hasNext())
                    current = external.next();
                return current.hasNext();
            }

            @Override
            public Integer next() {
                while (!current.hasNext() && external.hasNext())
                    current = external.next();
                return current.next();
            }
        };
    }

}
