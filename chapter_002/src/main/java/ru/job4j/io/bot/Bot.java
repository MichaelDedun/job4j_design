package ru.job4j.io.bot;

import java.io.*;

public class Bot implements BotAction {
    private final String endPhrase;
    private final Logger logger;
    private final String continueChatting;
    private final String stopChatting;
    private final String logFile;
    private final String answerFile;

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
        String action = "";
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
                    String answer = getAnswerFromFile();
                    logger.logByType(UsersType.BOT, answer);
                    System.out.println(answer);
                }
            } while (!action.equalsIgnoreCase(endPhrase));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAnswerFromFile() {
        String result = null;
        try (RandomAccessFile in = new RandomAccessFile(answerFile, "r")) {
            int countStr = 0;
            while (null != in.readLine()) {
                countStr++;
            }
            in.seek(0);
            int numberStr = (int) (Math.random() * countStr) + 1;
            int index = 0;
            while (index != numberStr) {
                result = in.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
