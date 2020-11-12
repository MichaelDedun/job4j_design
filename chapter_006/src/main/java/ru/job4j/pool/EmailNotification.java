package ru.job4j.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );


    public void emailTo(User user) {
        pool.submit(
                () -> {
                    String subject = String.format("Уведомление для {%s} по email {%s}", user.getUsername(), user.getEmail());
                    String body = String.format("Новое сообщение для {%s}", user.getUsername());
                    send(subject, body, user.getEmail());
                }
        );
    }

    public void send(String subject, String body, String email) {
        System.out.println(String.format("Тема: {%s}; Содержание: {%s}; Почта: {%s}", subject, body, email));
    }

    public void close() {
        pool.shutdown();
    }

    public static void main(String[] args) {
        User user = new User("Lalala", "kek@mail.ru");
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.emailTo(user);
        emailNotification.close();
    }

}
