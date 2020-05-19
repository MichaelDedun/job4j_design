package ru.job4j.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private Map<String, String> args = new HashMap<>();

    public ArgZip(String[] args) {
        this.args.put("d",args[1]);
        this.args.put("e",args[3]);
        this.args.put("O",args[5]);
    }

    public boolean valid() {
        return false;
    }

    public String directory() {
        return null;
    }

    public String exclude() {
        return null;
    }

    public String output() {
        return null;
    }

    public boolean checkDirectoryExist(String directory) {
        Path dir = Paths.get(directory());
        return Files.exists(dir);
    }

}
