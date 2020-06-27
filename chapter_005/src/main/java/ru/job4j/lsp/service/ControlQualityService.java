package ru.job4j.lsp.service;

import ru.job4j.lsp.model.Food;
import ru.job4j.lsp.model.Storage;
import ru.job4j.lsp.repository.SendToStorage;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ControlQualityService {

    public void distribution(Map<Storage, SendToStorage> dist) {
        Queue<Food> foods = new LinkedList<>();
        for (Storage storage : dist.keySet()) {
            Food food;
            while ((food = storage.get()) != null) {
                foods.add(food);
            }
        }
        ShellLifeCounter shellLifeCounter = new ShellLifeCounter();
        Food food;
        while ((food = foods.poll()) != null) {
            for (Storage storage : dist.keySet()) {
                if(dist.get(storage).execute(storage, food, shellLifeCounter.countShellLife(food.getCreateDate(), food.getExpiredDate())))
                    break;
            }
        }

    }

}
