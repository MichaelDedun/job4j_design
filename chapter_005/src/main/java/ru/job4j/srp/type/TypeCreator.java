package ru.job4j.srp.type;

import ru.job4j.srp.model.Employe;

import java.util.function.Predicate;

public interface TypeCreator {

    String createByType(Predicate<Employe> filter, String type);

}
