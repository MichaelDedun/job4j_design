package ru.job4j.srp.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

public class OldReportEngineTest {

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        OldReportEngine engine = new OldReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired().getTime() + ";" +
                worker.getFired().getTime() + ";" +
                worker.getSalary() + ";";
        assertThat(engine.generate(em -> true), is(expect));
    }

}