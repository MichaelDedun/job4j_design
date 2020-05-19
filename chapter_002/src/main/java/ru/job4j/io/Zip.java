package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        List<File> sources = new ArrayList<>();
        sources.add(source);
        packFiles(sources, target);
    }

    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        new Zip().packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/test.zip")
        );
    }

}
