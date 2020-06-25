package ru.job4j.srp.report;

import ru.job4j.srp.department.AccountancyDepartment;
import ru.job4j.srp.department.HrDepartment;
import ru.job4j.srp.department.ItDepartment;
import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportGeneratorFactory implements ReportGenerator {


    @Override
    public String generate(String format, Predicate<Employe> filter, String type, Store store) {
        switch (format.toLowerCase()) {
            case "it":
                return new ItDepartment().create(filter, type, store);
            case "acc":
                return new AccountancyDepartment().create(filter, type, store);
            case "hr":
                return new HrDepartment().create(filter, type, store);
            default:
                return null;
        }
    }
}
