package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;

import java.util.List;

public class ReportForAcc implements TypeCreator {

    @Override
    public String createByType(List<Employe> employes, String type) {
        StringBuilder text = new StringBuilder();
        for (Employe employe : employes) {
            text.append(employe.getName()).append(";")
                    .append(employe.getHired()).append(";")
                    .append(employe.getFired()).append(";")
                    .append(employe.getSalary()).append(";");
        }
        return text.toString();
    }

}
