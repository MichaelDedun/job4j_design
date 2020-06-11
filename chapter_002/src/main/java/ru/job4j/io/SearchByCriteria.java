package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchByCriteria {


    public static void main(String[] args) throws IOException {
        Context context = new Context();
        ArgsSearch argsSearch = new ArgsSearch(args);
        List<Path> result = new ArrayList<>();
        switch (argsSearch.searchTemplate()) {
            case "-m":
                context.setSearcher(new MaskSearcher());
                break;
            case "-f":
                context.setSearcher(new FullNameSearcher());
                break;
            case "-r":
                context.setSearcher(new RegexpSearcher());
            default:
                break;
        }
        result = context.executeSearcher(Paths.get(argsSearch.directory()), argsSearch.files());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(argsSearch.output()))) {
            if (result.size() != 0) {
                for (Path path : result) {
                    writer.write(path + System.lineSeparator());
                }
            } else {
                writer.write("Нет совпадений");
            }
        }
    }
}
