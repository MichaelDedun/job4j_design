package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.stream.Collectors;

public class AnaliseTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void checkUnavailable() throws IOException {
        String source = "./data/source.log";
        String result = "./data/result.txt";
        Analise analise = new Analise();
        analise.unavailable(source, result);
        BufferedReader in = new BufferedReader(new FileReader(result));
        for (String str : in.lines().collect(Collectors.toList())) {
            Assert.assertEquals("10:57:01 до 10:59:01", str);
            break;
        }
        in.close();
    }

    @Test
    public void checkUnavailableWithTemporary() throws IOException {
        Analise analise = new Analise();
        File source = folder.newFile("source");
        File result = folder.newFile("target");
        StringBuilder rsl = new StringBuilder();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
        }
        analise.unavailable(source.getAbsolutePath(), result.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(result))) {
            in.lines().forEach(rsl::append);
        }
        Assert.assertEquals("10:57:01 до 10:59:01", rsl.toString());
    }

}