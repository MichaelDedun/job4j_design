package ru.job4j;

public class Wget {

    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("start print");
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(1000);
                            System.out.print("\rLoading : " + i + "%");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        thread.start();
        System.out.println("Main");
    }
}
