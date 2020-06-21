package ru.job4j.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxAndMinTest {


    @Test
    public void testMax() {
        List<Dog> values = new ArrayList<>(Arrays.asList(
                new Dog(1),
                new Dog(2),
                new Dog(3),
                new Dog(4),
                new Dog(5)
        ));
        MaxAndMin max = new MaxAndMin();
        Dog actual = (Dog) max.max(values, Comparator.comparing(Dog::getAge));
        assertThat(values.get(4), is(actual));
    }

    @Test
    public void testMin() {
        List<Dog> values = new ArrayList<>(Arrays.asList(
                new Dog(1),
                new Dog(2),
                new Dog(3),
                new Dog(4),
                new Dog(5)
        ));
        MaxAndMin max = new MaxAndMin();
        Dog actual = max.min(values, Comparator.comparing(Dog::getAge));
        assertThat(values.get(0), is(actual));
    }

}