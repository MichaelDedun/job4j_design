package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchByCriteria {

    public static void writeLog(List<Path> result, String src) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(src))) {
            if (result.size() != 0) {
                for (Path path : result) {
                    writer.write(path + System.lineSeparator());
                }
            } else {
                writer.write("Нет совпадений");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Context context = new Context();
        ArgsSearch argsSearch = new ArgsSearch(args);
        ConditionFactory conditionFactory = new ConditionFactory();
        List<Path> result = context.search(Paths.get(argsSearch.directory()),
                conditionFactory.newCondition(argsSearch.searchTemplate(), argsSearch.files()));
        SearchByCriteria.writeLog(result, argsSearch.output());
    }
}
