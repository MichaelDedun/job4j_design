package ru.job4j.io.bot;

public class RunApplication {

    public static void main(String[] args) {
        Logger logger = new Logger();
        ConsoleInput input = new ConsoleInput();
        Bot bot = new Bot("закончить", logger, "Продолжить", "Стоп", "log.txt", "wordsForAnswer.txt");
        bot.run(input, false);
    }

}
