package ru.job4j.srp.service;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.ReportGeneratorFactory;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

public class ReportEngine {

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        ReportGeneratorFactory factory = new ReportGeneratorFactory();
        Employe worker = new Employe("Ivan", now, now, 100);
        store.add(worker);
        Employe worker1 = new Employe("Test", now, now, 23);
        store.add(worker1);
        Employe worker2 = new Employe("Test1", now, now, 40);
        store.add(worker2);
        Employe worker3 = new Employe("Test2", now, now, 60);
        store.add(worker3);
        Employe worker4 = new Employe("Test3", now, now, 78);
        store.add(worker4);
        Employe worker5 = new Employe("Test4", now, now, 400);
        store.add(worker5);
//        System.out.println(factory.generate("It", employer -> employer.getHired().equals(now), "html", store));
//        System.out.println(factory.generate("Hr", employer -> employer.getHired().equals(now), "desc,name,salary", store));
        System.out.println(factory.generate("acc", employer -> employer.getHired().equals(now), "dollar", store));
   }
}
