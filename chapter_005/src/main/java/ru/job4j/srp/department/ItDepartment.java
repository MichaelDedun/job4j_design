package ru.job4j.srp.department;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.Report;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForIt;

import java.util.function.Predicate;

public class ItDepartment implements Report {

    @Override
    public String create(Predicate<Employe> filter, String type, Store store) {
        ReportForIt it = new ReportForIt(store);
        return it.createByType(filter,type);
    }

}
