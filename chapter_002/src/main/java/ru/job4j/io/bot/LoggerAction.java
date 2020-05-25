package ru.job4j.io.bot;

public interface LoggerAction {

    void logByType(UsersType userType, String message);

    void saveLog();

}
