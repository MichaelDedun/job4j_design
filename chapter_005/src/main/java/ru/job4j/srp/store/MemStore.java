package ru.job4j.srp.store;

import ru.job4j.srp.model.Employe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {

    private final List<Employe> employes = new ArrayList<>();

    public void add(Employe em) {
        employes.add(em);
    }

    @Override
    public List<Employe> findBy(Predicate<Employe> filter) {
       return employes.stream().filter(filter).collect(Collectors.toList());
    }

}
