package ru.job4j.io.bot;

public class RunApplication {

    public static void main(String[] args) {
        Logger logger = new Logger();
        Bot bot = new Bot("закончить", logger, "Продолжить", "Стоп", "log.txt", "wordsForAnswer.txt");
        ConsoleInput input = new ConsoleInput();
        bot.run(input, false);
    }

}
