package ru.job4j.srp.department;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.ReportPreparer;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForHr;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HrDepartment implements ReportPreparer {

    @Override
    public String prepare(Predicate<Employe> filter, String type, Store store) {
        String[] args = type.split(",");
        List<Employe> employes = store.findBy(filter);
        switch (args[0]) {
            case "inc":
                employes.sort(Comparator.comparingDouble(Employe::getSalary));
            case "desc":
                employes.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
            default:
                break;
        }
        return new ReportForHr().createByType(employes, type);
    }

}
