package ru.job4j.srp.department;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.ReportPreparer;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForIt;

import java.util.List;
import java.util.function.Predicate;

public class ItDepartment implements ReportPreparer {

    @Override
    public String prepare(Predicate<Employe> filter, String type, Store store) {
        List<Employe> employes = store.findBy(filter);
        return new ReportForIt().createByType(employes,type);
    }

}
