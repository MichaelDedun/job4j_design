package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public interface Searcher {

    List<Path> search(Path root, Predicate<Path> condition) throws IOException;

}
