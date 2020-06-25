package ru.job4j.srp.department;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.Report;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForHr;

import java.util.function.Predicate;

public class HrDepartment implements Report {

    @Override
    public String create(Predicate<Employe> filter, String type, Store store) {
        ReportForHr hr = new ReportForHr(store);
        return hr.createByType(filter,type);
    }

}
