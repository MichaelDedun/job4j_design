package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;

import java.util.List;

public interface TypeCreator {

    String createByType(List<Employe> employes, String type);

}
