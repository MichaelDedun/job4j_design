package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Storage;
import ru.job4j.lsp.repository.SendToStorage;

public class PutInTrash implements SendToStorage {

    @Override
    public boolean execute(Storage storage, Food food, Double shellLife) {
        boolean result = false;
        if (shellLife > 1.0) {
            storage.add(food);
            result = true;
        }
        return result;
    }

}
