package ru.job4j.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AnaliseTest {

    @Test
    public void checkInfo() {
        List<Analise.User> previous = new ArrayList<>(
                Arrays.asList(
                        new Analise.User(1, "Vova"),
                        new Analise.User(2, "Misha"),
                        new Analise.User(4, "Danon"),
                        new Analise.User(3, "Dimas")
                )
        );

        List<Analise.User> current = new ArrayList<>(
                Arrays.asList(
                        new Analise.User(1, "Vova"),
                        new Analise.User(2, "Peti"),
                        new Analise.User(3, "ASDAS"),
                        new Analise.User(5, "Test")
                )
        );
        Analise analise = new Analise();
        Analise.Info info = new Analise.Info(1,2,1);
        assertEquals(info, analise.diff(previous,current));
    }

    @Test
    public void whenNotChanged() {
        Analise.User u1 = new Analise.User(1, "A");
        Analise.User u2 = new Analise.User(2, "B");
        Analise.User u3 = new Analise.User(3, "C");
        List<Analise.User> previous = List.of(u1, u2, u3);
        List<Analise.User> current = List.of(u1, u2, u3);
        Analise.Info result = Analise.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenOneChanged() {
        Analise.User u1 = new Analise.User(1, "A");
        Analise.User u2 = new Analise.User(2, "B");
        Analise.User u3 = new Analise.User(3, "C");
        List<Analise.User> previous = List.of(u1, u2, u3);
        List<Analise.User> current = List.of(u1, new Analise.User(2, "BB"), u3);
        Analise.Info result = Analise.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenOneDeleted() {
        Analise.User u1 = new Analise.User(1, "A");
        Analise.User u2 = new Analise.User(2, "B");
        Analise.User u3 = new Analise.User(3, "C");
        List<Analise.User> previous = List.of(u1, u2, u3);
        List<Analise.User> current = List.of(u1, u3);
        Analise.Info result = Analise.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(1));
    }

    @Test
    public void whenOneAdded() {
        Analise.User u1 = new Analise.User(1, "A");
        Analise.User u2 = new Analise.User(2, "B");
        Analise.User u3 = new Analise.User(3, "C");
        List<Analise.User> previous = List.of(u1, u2, u3);
        List<Analise.User> current = List.of(u1, u2, u3, new Analise.User(4, "D"));
        Analise.Info result = Analise.diff(previous, current);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }


}
