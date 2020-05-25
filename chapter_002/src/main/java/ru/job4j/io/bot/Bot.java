package ru.job4j.io.bot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bot implements BotAction {
    private final String endPhrase;
    private final Logger logger;
    private final String continueChatting;
    private final String stopChatting;
    private final String logFile;
    private final String answerFile;
    private List<String> answers = new ArrayList<>();

    public Bot(String endPhrase, Logger logger, String continueChatting, String stopChatting, String logFile, String answerFile) {
        this.endPhrase = endPhrase;
        this.logger = logger;
        this.continueChatting = continueChatting;
        this.stopChatting = stopChatting;
        this.logFile = logFile;
        this.answerFile = answerFile;
    }

    @Override
    public void run(Input input, boolean stopFlag) {
        saveAnswers();
        String action;
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile))) {
            logger.setOut(writer);
            do {
                action = input.askStr();
                logger.logByType(UsersType.HUMAN, action);
                if (action.equalsIgnoreCase(continueChatting))
                    stopFlag = false;
                if (action.equalsIgnoreCase(stopChatting))
                    stopFlag = true;
                if (!stopFlag && !action.equalsIgnoreCase(endPhrase)) {
                    String answer = getAnswer();
                    logger.logByType(UsersType.BOT, answer);
                    System.out.println(answer);
                }
            } while (!action.equalsIgnoreCase(endPhrase));
            logger.saveLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAnswers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(answerFile))) {
            reader.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        int index = (int) (Math.random() * (answers.size()));
        return answers.get(index);
    }

}
