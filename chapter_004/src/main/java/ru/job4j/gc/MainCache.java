package ru.job4j.gc;

public class MainCache {

    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache("");
        cache.put("Even.txt");
        System.out.println(cache.get("Even.txt"));
        SimpleCache cacheWithSrc = new SimpleCache("chapter_002/data");
        cacheWithSrc.put("pair_without_comment.properties");
        System.out.println(cacheWithSrc.get("pair_without_comment.properties"));
    }

}
