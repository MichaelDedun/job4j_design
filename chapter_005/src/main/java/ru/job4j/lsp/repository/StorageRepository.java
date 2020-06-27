package ru.job4j.lsp.repository;

import ru.job4j.lsp.model.Food;

public interface StorageRepository {

    boolean add(Food food);

    Food get();
}
