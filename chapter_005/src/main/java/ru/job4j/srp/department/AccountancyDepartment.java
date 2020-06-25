package ru.job4j.srp.department;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.Report;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForAcc;

import java.util.function.Predicate;

public class AccountancyDepartment implements Report {


    @Override
    public String create(Predicate<Employe> filter, String type, Store store) {
        ReportForAcc acc = new ReportForAcc(store);
        return acc.createByType(filter, type);
    }
}
