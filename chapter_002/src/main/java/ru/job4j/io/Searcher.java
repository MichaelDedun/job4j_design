package ru.job4j.io;

import java.nio.file.Path;
import java.util.List;

public interface Searcher {

    List<Path> search(Path root, String ext);

}
