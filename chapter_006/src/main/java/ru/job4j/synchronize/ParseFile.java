package ru.job4j.synchronize;

import java.io.*;

public class ParseFile {
    private File file;
    private String content;
    private SaveFile saveFile;

    public ParseFile(File f, SaveFile saveFile) throws IOException {
        file = f;
        this.saveFile = saveFile;
        content = initContent();
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() {
        return content;
    }

    private synchronized String initContent() {
        try (BufferedReader i = new BufferedReader(new FileReader(file))) {
            StringBuilder output = new StringBuilder();
            int data;
            while ((data = i.read()) > 0) {
                output.append((char) data);
            }
            return output.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public synchronized String getContentWithoutUnicode() {
        try (BufferedReader i = new BufferedReader(new FileReader(file))) {
            StringBuilder output = new StringBuilder();
            int data;
            while ((data = i.read()) > 0) {
                if (data < 0x80) {
                    output.append((char) data);
                }
            }
            return output.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public synchronized void saveContent(String content, File file) {
        saveFile.saveContent(content, file);
    }

}
