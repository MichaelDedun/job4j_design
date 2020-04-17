package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) == null) {
            return false;
        }
        T result = findById(id);
        int index = mem.indexOf(result);
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(findById(id));
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .flatMap(Stream::of)
                .filter(model -> model.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
