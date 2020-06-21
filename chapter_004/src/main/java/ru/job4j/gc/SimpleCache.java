package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
    private final String src;
    private Map<String, SoftReference<String>> map = new HashMap<>();

    public SimpleCache(String src) {
        this.src = src;
    }

    public String get(String key) {
        if (!map.containsKey(key)) {
            put(key);
        } else if (map.get(key).get() == null) {
            put(key);
        }
        return map.get(key).get();
    }

    public void put(String key) {
        map.put(key, new SoftReference<>(readValue(key)));
    }

    public String readValue(String value) {
        StringBuilder res = new StringBuilder();
        if (src.isEmpty()) {
            try (BufferedReader out = new BufferedReader(new FileReader(value))) {
                String str;
                while ((str = out.readLine()) != null) {
                    res.append(str).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedReader out = new BufferedReader(new FileReader(src + "/" + value))) {
                String str;
                while ((str = out.readLine()) != null) {
                    res.append(str).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res.toString();
    }

}