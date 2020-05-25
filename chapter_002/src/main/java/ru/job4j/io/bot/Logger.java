package ru.job4j.io.bot;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Logger implements LoggerAction {
    private Writer out;
    private List<String> log = new ArrayList<>();

    public Logger() {
    }

    @Override
    public void logByType(UsersType userType, String message) {
        log.add(String.format("Type : %s, message : %s", userType.getValue(), message));
    }

    @Override
    public void saveLog() {
        try {
            for (String str : log)
                out.write(str + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOut(Writer out) {
        this.out = out;
    }

}
