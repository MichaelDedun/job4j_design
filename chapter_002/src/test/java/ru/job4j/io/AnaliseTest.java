package ru.job4j.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class AnaliseTest {

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

}