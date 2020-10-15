package ru.job4j.synchronize;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveFile {

    public void saveContent(String content, File file) {
        try (BufferedWriter o = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
