package ru.job4j.srp.report;

import ru.job4j.srp.department.AccountancyDepartment;
import ru.job4j.srp.department.HrDepartment;
import ru.job4j.srp.department.ItDepartment;
import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportGeneratorFactory implements ReportGenerator {

    @Override
    public String generate(String department, Predicate<Employe> filter, String type, Store store) {
        switch (department.toLowerCase()) {
            case "it":
                return new ItDepartment().prepare(filter, type, store);
            case "acc":
                return new AccountancyDepartment().prepare(filter, type, store);
            case "hr":
                return new HrDepartment().prepare(filter, type, store);
            default:
                return null;
        }
    }

}
