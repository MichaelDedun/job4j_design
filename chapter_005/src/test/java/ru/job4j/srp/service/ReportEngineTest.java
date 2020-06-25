package ru.job4j.srp.service;

import org.junit.Test;
import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.ReportGeneratorFactory;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenItGeneratedHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        String expect = "<html>" + System.lineSeparator() +
                "<head>" + System.lineSeparator() +
                "<title>" + "Report" + "</title>" + System.lineSeparator() +
                "</head>" + System.lineSeparator() +
                "<body>" + System.lineSeparator() +
                "<table>" + System.lineSeparator() +
                "<tr>" + System.lineSeparator() +
                "<th>" + "Name" + "</th>" + System.lineSeparator() +
                "<th>" + "Hired" + "</th>" + System.lineSeparator() +
                "<th>" + "Fired" + "</th>" + System.lineSeparator() +
                "<th>" + "Salary" + "</th>" + System.lineSeparator() +
                "</tr>" + System.lineSeparator() +
                "<tr>" + System.lineSeparator() +
                "<td>" + worker.getName() + "</td>" + System.lineSeparator() +
                "<td>" + worker.getHired().getTime() + "</td>" + System.lineSeparator() +
                "<td>" + worker.getFired().getTime() + "</td>" + System.lineSeparator() +
                "<td>" + worker.getSalary() + "</td>" + System.lineSeparator() +
                "</tr>" + System.lineSeparator() +
                "</table>" + System.lineSeparator() +
                "</body>" + System.lineSeparator() +
                "</html>" + System.lineSeparator();
        assertThat(factory.generate("it", employer -> employer.getHired().equals(now), "html", store), is(expect));
    }

    @Test
    public void whenItGeneratedXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + System.lineSeparator() +
                "<employers>" + System.lineSeparator() +
                "<employer>" + System.lineSeparator() +
                "<name>" + worker.getName() + "</name>" + System.lineSeparator() +
                "<hired>" + worker.getHired().getTime() + "</hired>" + System.lineSeparator() +
                "<fired>" + worker.getFired().getTime() + "</fired>" + System.lineSeparator() +
                "<salary>" + worker.getSalary() + "</salary>" + System.lineSeparator() +
                "</employer>" + System.lineSeparator() +
                "</employers>" + System.lineSeparator();
        assertThat(factory.generate("it", employer -> employer.getHired().equals(now), "xml", store), is(expect));
    }

    @Test
    public void whenItGeneratedJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        String ls = System.lineSeparator();
        String expect = "{" + ls +
                "\"name\": " + "\"" + worker.getName() + "\"," + ls +
                "\"hired\": " + worker.getHired().getTime() + "," + ls +
                "\"fired\": " + worker.getFired().getTime() + "," + ls +
                "\"salary\": " + worker.getSalary() + "," + ls +
                "}" + ls;
        assertThat(factory.generate("it", employer -> employer.getHired().equals(now), "json", store), is(expect));
    }

    @Test
    public void whenHrGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker1 = new Employe("Ivan", now, now, 100);
        Employe worker2 = new Employe("Peti", now, now, 200);
        Employe worker3 = new Employe("Misha", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        String expect = System.lineSeparator() +
                "Имя " + worker3.getName() + " " +
                "Зарплата " + worker3.getSalary() + " " +
                ";" +
                System.lineSeparator() +
                "Имя " + worker2.getName() + " " +
                "Зарплата " + worker2.getSalary() + " " +
                ";" +
                System.lineSeparator() +
                "Имя " + worker1.getName() + " " +
                "Зарплата " + worker1.getSalary() + " " +
                ";";
        assertThat(factory.generate("hr", employer -> employer.getHired().equals(now), "desc,name,salary", store), is(expect));
    }

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        String expect = worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() * 69.27 + ";";
        assertEquals(factory.generate("acc", employer -> employer.getHired().equals(now), "dollar", store), expect);
    }

}