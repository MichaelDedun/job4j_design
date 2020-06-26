package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;

import java.util.List;

public class ReportForHr implements TypeCreator {

    @Override
    public String createByType(List<Employe> employes, String type) {
        StringBuilder result = new StringBuilder();
        for (Employe employe : employes) {
            result.append(System.lineSeparator());
            if (type.contains("name")) result.append("Имя ").append(employe.getName()).append(" ");
            if (type.contains("hired")) result.append("Дата найма ").append(employe.getHired().getTime()).append(" ");
            if (type.contains("fired")) result.append("Дата увольнения ").append(employe.getFired().getTime()).append(" ");
            if (type.contains("salary")) result.append("Зарплата ").append(employe.getSalary()).append(" ");
            result.append(";");
        }
        return result.toString();
    }

}
