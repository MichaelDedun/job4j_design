package ru.job4j.io;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArgsSearch {

    private String directory;
    private String files;
    private String searchTemplate;
    private String output;

    public ArgsSearch(String[] args) throws FileNotFoundException {
        valid(args);
        this.directory = checkDirectory(args);
        this.files = checkFiles(args);
        switch (args[4]) {
            case "-m":
                searchTemplate = checkMask(args[4], files);
                break;
            case "-f":
                searchTemplate = checkFullName(args[4]);
                break;
            case "-r":
                searchTemplate = checkRegexp(args[4]);
                break;
            default:
                break;
        }
        this.output = checkOutput(args);
    }

    public void valid(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");

    }

    public String directory() {
        return this.directory;
    }

    public String files() {
        return this.files;
    }

    public String searchTemplate() {
        return this.searchTemplate;
    }

    public String output() {
        return this.output;
    }

    public String checkDirectory(String[] args) throws FileNotFoundException {
        if (!Arrays.toString(args).contains("-d")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String directory = "";
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-d") && args[i + 1].matches("^(.+)([^\\/]+)$")) {
                directory = args[i + 1];
                break;
            }
        }
        if (!Files.exists(Paths.get(directory))) {
            throw new FileNotFoundException("Catalog dont exist");
        }
        return directory;
    }

    public String checkFiles(String[] args) {
        if (!Arrays.toString(args).contains("-n")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String filesForSearch = "";
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-n")) {
                filesForSearch = args[i + 1];
                break;
            }
        }
        return filesForSearch;
    }

    public String checkMask(String mask, String filesForSearch) {
        if (!mask.equals("-m")) {
            throw new IllegalArgumentException("-m not exist");
        }
        this.files = filesForSearch.replace("*", "");
        return mask;
    }

    public String checkFullName(String fullName) {
        if (!fullName.equals("-f")) {
            throw new IllegalArgumentException("-f not exist");
        }
        return fullName;
    }

    public String checkRegexp(String regexp) {
        if (!regexp.equals("-r")) {
            throw new IllegalArgumentException("-r not exist");
        }
        return regexp;
    }

    public String checkOutput(String[] args) {
        if (!Arrays.toString(args).contains("-o")) {
            throw new IllegalArgumentException("-d dont exist");
        }
        String output = "";
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-o")) {
                output = args[i + 1];
                break;
            }
        }
        return output;
    }
}
