package ru.job4j.srp.store;

import ru.job4j.srp.model.Employe;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employe> findBy(Predicate<Employe> filter);

}
