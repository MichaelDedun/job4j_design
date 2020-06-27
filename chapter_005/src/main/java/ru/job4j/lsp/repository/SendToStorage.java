package ru.job4j.lsp.repository;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Storage;

public interface SendToStorage {

    boolean execute(Storage storage, Food food, Double shellLife);
}
