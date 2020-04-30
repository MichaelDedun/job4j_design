package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else {
            mem.set(index, model);
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    public int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (T el : mem) {
            if (el.getId().equals(id)) {
                rsl = index;
            }
            index++;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

}
