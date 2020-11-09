package ru.job4j.nonblockingalgorithm;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private final ConcurrentHashMap<Integer, Base> container = new ConcurrentHashMap<>();

    public void add(Base model) {
        container.putIfAbsent(model.getId(), model);
    }

    public boolean update(Base model) {
        container.computeIfPresent(model.getId(), (key, value) -> {
            if (value.getVersion() != model.getVersion()) {
                throw new OptimisticException("Версии не равны");
            }
            Base newBase = new Base(model.getId(), model.getName());
            newBase.setVersion(model.getVersion() + 1);
            return newBase;
        });
        return true;
    }

    public void delete(Base model) {
        container.values().removeIf(model1 -> model1.equals(model));
    }

    public void check() {
        System.out.println(container);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        Base base = new Base(0, "Kek");
        cache.add(base);
        Thread thread = new Thread(
                () -> {

                    cache.update(base);
                    cache.delete(base);
                    cache.check();

                }
        );
        Thread thread1 = new Thread(
                () -> {

                    cache.update(base);
                    cache.check();
                    cache.delete(base);
                    cache.check();

                }
        );
        thread.start();
        thread1.start();
    }

}
