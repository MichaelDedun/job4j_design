package ru.job4j.io.bot;

import java.io.IOException;
import java.io.Writer;

public class Logger implements LoggerAction {
    private Writer out;

    public Logger() {
    }

    @Override
    public void logByType(UsersType userType, String message) {
        try {
            out.write(String.format("Type : %s, message : %s", userType.getValue(), message) + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOut(Writer out) {
        this.out = out;
    }

}
