package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analise {

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source)); PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = "";
            String end;
            String str = "";
            while ((str = in.readLine()) != null) {
                if (!str.isEmpty()) {
                    if (str.contains("400") || str.contains("500")) {
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
