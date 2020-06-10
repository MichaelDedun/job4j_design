package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        search(Paths.get(args[0]), args[1]).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getListPaths();
    }

    public static List<Path> searchByMask(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getListPaths();
    }

    public static List<Path> searchByFullName(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().equals(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getListPaths();
    }

    public static List<Path> searchByRegexp(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().matches(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getListPaths();
    }

}
