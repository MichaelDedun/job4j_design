package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHr implements TypeCreator {
    private Store store;

    public ReportForHr(Store store) {
        this.store = store;
    }

    @Override
    public String createByType(Predicate<Employe> filter, String type) {
        String[] args = type.split(",");
        switch (args[0]) {
            case "inc":
                return createAndSortByTypeAndField(filter, Comparator.comparingDouble(Employe::getSalary), args);
            case "desc":
                return createAndSortByTypeAndField(filter, (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()), args);
            default:
                return null;
        }
    }

    private String createAndSortByTypeAndField(Predicate<Employe> filter, Comparator<Employe> comparator, String[] fields) {
        String fieldsForRep = Arrays.toString(fields);
        StringBuilder result = new StringBuilder();
        List<Employe> employes = store.findBy(filter);
        employes.sort(comparator);
        for (Employe employe : employes) {
            result.append(System.lineSeparator());
            if (fieldsForRep.contains("name")) result.append("Имя ").append(employe.getName()).append(" ");
            if (fieldsForRep.contains("hired")) result.append("Дата найма ").append(employe.getHired().getTime()).append(" ");
            if (fieldsForRep.contains("fired")) result.append("Дата увольнения ").append(employe.getFired().getTime()).append(" ");
            if (fieldsForRep.contains("salary")) result.append("Зарплата ").append(employe.getSalary()).append(" ");
            result.append(";");
        }
        return result.toString();
    }

}
