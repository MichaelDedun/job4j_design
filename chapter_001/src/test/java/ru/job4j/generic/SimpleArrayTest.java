package ru.job4j.generic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void testArray() {
        SimplyArray<Integer> array = new SimplyArray<>(5);
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(10);
        array.add(11);
        array.set(4,15);
        array.remove(2);
        int num = array.get(0);
        int num1 = array.get(1);
        int num2 = array.get(2);
        int num3 = array.get(3);
        int[] result = {num,num1,num2,num3};
        assertThat(new int[]{5, 4, 10, 15}, is(result));
    }

    @Test
    public void testIter() {
        SimplyArray<Integer> array = new SimplyArray<>(5);
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(10);
        array.add(11);
        SimplyArrayIterator it = (SimplyArrayIterator) array.iterator();
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(5));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(10));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(11));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(false));
    }


}