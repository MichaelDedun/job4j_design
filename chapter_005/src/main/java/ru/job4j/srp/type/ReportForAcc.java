package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public class ReportForAcc implements TypeCreator {
    private Store store;

    public ReportForAcc(Store store) {
        this.store = store;
    }

    @Override
    public String createByType(Predicate<Employe> filter, String type) {
        switch (type.toLowerCase()) {
            case "dollar":
                return createByCourse(69.27, filter);
            case "euro":
                return createByCourse(77.62, filter);
            default:
                return null;
        }
    }

    private String createByCourse(Double course, Predicate<Employe> filter) {
        StringBuilder text = new StringBuilder();
        for (Employe employe : store.findBy(filter)) {
            text.append(employe.getName()).append(";")
                    .append(employe.getHired()).append(";")
                    .append(employe.getFired()).append(";")
                    .append(employe.getSalary() * course).append(";");
        }
        return text.toString();
    }

}
