package ru.job4j.srp.report;

import ru.job4j.srp.model.Employe;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;

public interface ReportPreparer {

    String prepare(Predicate<Employe> filter, String type, Store store);

}
