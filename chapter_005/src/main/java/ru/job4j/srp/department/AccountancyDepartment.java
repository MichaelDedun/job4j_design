package ru.job4j.srp.department;

import ru.job4j.srp.enums.Type;
import ru.job4j.srp.model.Employe;
import ru.job4j.srp.report.ReportPreparer;
import ru.job4j.srp.store.Store;
import ru.job4j.srp.type.ReportForAcc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountancyDepartment implements ReportPreparer {

    @Override
    public String prepare(Predicate<Employe> filter, String type, Store store) {
        List<Employe> employes = new ArrayList<>();
        switch (type.toLowerCase()) {
            case "dollar":
                employes = store.findBy(filter).stream().peek(employe -> employe.setSalary(employe.getSalary() / Type.Dollar.getRate())).collect(Collectors.toList());
                break;
            case "euro":
                employes = store.findBy(filter).stream().peek(employe -> employe.setSalary(employe.getSalary() / Type.Euro.getRate())).collect(Collectors.toList());
                break;
            default:
                break;
        }
        return new ReportForAcc().createByType(employes, type);
    }

}
