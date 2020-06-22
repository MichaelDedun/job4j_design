package ru.job4j.gc;

public class MainCache {

    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache("");
        System.out.println(cache.get("Even.txt"));
        SimpleCache cacheWithSrc = new SimpleCache("chapter_002/data");
        System.out.println(cacheWithSrc.get("pair_without_comment.properties"));
    }

}
