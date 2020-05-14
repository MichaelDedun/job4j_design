package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Analise {

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source)); PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = "";
            String end;
            for (String str : in.lines().collect(Collectors.toList())) {
                if (!str.isEmpty()) {
                    String state = str.substring(0, str.indexOf(" "));
                    if (state.equals("400") || state.equals("500")) {
                        if (start.isEmpty()) {
                            start = str.substring(str.indexOf(" ") + 1);
                        }
                    } else {
                        end = str.substring(str.indexOf(" ") + 1);
                        if (!start.isEmpty()) {
                            out.write(start + " до " + end + System.lineSeparator());
                            start = "";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analise analise = new Analise();
        analise.unavailable("server.log", "target.txt");
    }

}
