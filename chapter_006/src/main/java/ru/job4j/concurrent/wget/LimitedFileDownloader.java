package ru.job4j.concurrent.wget;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class LimitedFileDownloader {

    public static void main(String[] args) {
        Arg arg = new Arg(args);
        readFile(arg.getUrlFromArgs(), arg.getSpeedFromArgs());
    }

    public static void readFile(String url, Integer speed) {
        long startTime = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            long endTime = System.currentTimeMillis();
            int delay = 0;
            int countSec = (int) ((int) endTime - startTime);
            if (countSec > 1) delay = countSec / speed;
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
