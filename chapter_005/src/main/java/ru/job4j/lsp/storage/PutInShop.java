package ru.job4j.lsp.storage;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Storage;
import ru.job4j.lsp.repository.SendToStorage;

public class PutInShop implements SendToStorage {

    @Override
    public boolean execute(Storage storage, Food food, Double shellLife) {
        boolean result = false;
        if (shellLife > 0.25 && shellLife <= 0.75) {
            storage.add(food);
            result = true;
        } else if (shellLife > 0.75 && shellLife <= 1.0) {
            food.setDiscount(20);
            storage.add(food);
            result = true;
        }
        return result;
    }

}
