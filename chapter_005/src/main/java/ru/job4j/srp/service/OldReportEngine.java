package ru.job4j.srp.service;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class OldReportEngine {
    private Store store;

    public OldReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employe> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employe employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
