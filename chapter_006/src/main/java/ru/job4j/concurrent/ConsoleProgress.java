package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    public static void main(String[] args) {
        ConsoleProgress consoleProgress = new ConsoleProgress();
        Thread thread = new Thread(consoleProgress);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        String[] symbols = {"-", "|", "/"};
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\rLoading : " + symbols[index]);
            index = (index == 2) ? 0 : index + 1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
