package ru.job4j.io;

import java.nio.file.Path;
import java.util.List;

public class Context {
    private Searcher searcher;

    public List<Path> executeSearcher(Path root, String ext) {
        return searcher.search(root, ext);
    }

    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

}
