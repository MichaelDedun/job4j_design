package ru.job4j.io.bot;

public interface BotAction {

    void run(Input input, boolean stopFlag);

    void saveAnswers();

    String getAnswer();

}
