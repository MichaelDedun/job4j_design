package ru.job4j.io;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArgZip {

    private String directory;
    private String exclude;
    private String output;

    public ArgZip(String[] args) throws FileNotFoundException {
        valid(args);
        this.directory = checkDirectory(args);
        this.exclude = checkExclude(args);
        this.output = checkOutput(args);
    }

    public void valid(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");

    }

    public String directory() {
        return this.directory;
    }

    public String exclude() {
        return this.exclude;
    }

    public String output() {
        return this.output;
    }

    public String checkDirectory(String[] args) throws FileNotFoundException {
        if (!Arrays.toString(args).contains("-d")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String directory = "";
        ////Если -d находится не в нулевой позиции
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-d") && args[i+1].matches("^(.+)([^\\/]+)$")) {
                directory = args[i + 1];
                break;
            }
        }
        if (!Files.exists(Paths.get(directory))) {
            throw new FileNotFoundException("Catalog dont exist");
        }
        return directory;
    }

    public String checkExclude(String[] args) {
        if (!Arrays.toString(args).contains("-e")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String exclude = "";
        ////Если -e находится не в нулевой позиции
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-e")) {
                exclude = args[i + 1].replace("*","");
                break;
            }
        }
        return exclude;
    }

    public String checkOutput(String[] args) {
        if (!Arrays.toString(args).contains("-o")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String output = "";
        ////Если -o находится не в нулевой позиции
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-o")) {
                output = args[i + 1];
                break;
            }
        }
        return output;
    }

}
