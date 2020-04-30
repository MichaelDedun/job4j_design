package ru.job4j.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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


}
