package ru.job4j.io;

import java.nio.file.Path;
import java.util.function.Predicate;

public class ConditionFactory {
    private Predicate<Path> result;

    public Predicate<Path> newCondition(String searchTemplate, String ext) {
        switch (searchTemplate) {
            case "-m":
                result = p -> p.toFile().getName().endsWith(ext);
                break;
            case "-f":
                result = p -> p.toFile().getName().equals(ext);
                break;
            case "-r":
                result = p -> p.toFile().getName().matches(ext);
            default:
                break;
        }
        return result;
    }
}
