package ru.job4j.lsp.service;

import org.junit.Test;
import ru.job4j.lsp.model.*;
import ru.job4j.lsp.repository.SendToStorage;
import ru.job4j.lsp.storage.PutInShop;
import ru.job4j.lsp.storage.PutInTrash;
import ru.job4j.lsp.storage.PutInWarehouse;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class ControlQualityServiceTest {

    @Test
    public void testDistribution() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQualityService service = new ControlQualityService();
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(10));
        Date expaired = java.sql.Date.valueOf(now.plusDays(15));
        Date created1 = java.sql.Date.valueOf(now.minusDays(5));
        Date expaired1 = java.sql.Date.valueOf(now.plusDays(3));
        Food food = new Food("Apple", expaired, created, 10.0, 0);
        Food food1 = new Food("milk", expaired1, created1, 20.0, 0);
        warehouse.add(food);
        trash.add(food1);
        Map<Storage, SendToStorage> map = new HashMap<>();
        map.put(warehouse, new PutInWarehouse());
        map.put(shop, new PutInShop());
        map.put(trash, new PutInTrash());
        service.distribution(map);
        assertEquals(shop.get().getName(), food.getName());
    }

}