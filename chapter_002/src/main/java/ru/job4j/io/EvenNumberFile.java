package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] temp = text.toString().replaceAll("\n", " ").split(" ");
            for (String el : temp) {
                if (Integer.parseInt(el) % 2 == 0) {
                    System.out.println("четное");
                } else {
                    System.out.println("Нечетное");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
