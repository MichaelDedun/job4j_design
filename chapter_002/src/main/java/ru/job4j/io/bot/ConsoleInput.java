package ru.job4j.io.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private BufferedReader reader;

    public ConsoleInput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String askStr() {
        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
