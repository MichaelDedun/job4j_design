package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxAndMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMinOrMax(value, (o1, o2) -> comparator.compare(o1, o2) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMinOrMax(value, (o1, o2) -> comparator.compare(o1, o2) < 0);
    }

    private <T> T findMinOrMax(List<T> value, BiPredicate<T, T> check) {
        T result = value.get(0);
        for (T el : value) {
            if (check.test(el, result)) {
                result = el;
            }
        }
        return result;
    }

}
