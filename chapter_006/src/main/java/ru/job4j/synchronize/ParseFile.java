package ru.job4j.synchronize;

import java.io.*;

public class ParseFile {
    private File file;
    private String content;

    public ParseFile(File f) throws IOException {
        file = f;
        content = initContent();
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() {
        return content;
    }

    public synchronized String initContent() {
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

    public synchronized void saveContent(String content) {
        try (BufferedWriter o = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
