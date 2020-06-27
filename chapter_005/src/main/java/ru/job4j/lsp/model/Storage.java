package ru.job4j.lsp.model;

import ru.job4j.lsp.repository.StorageRepository;

import java.util.LinkedList;
import java.util.Queue;

public class Storage implements StorageRepository {
    private Queue<Food> foods = new LinkedList<>();

    @Override
    public boolean add(Food food) {
       return foods.add(food);
    }

    @Override
    public Food get() {
        return foods.poll();
    }

}
