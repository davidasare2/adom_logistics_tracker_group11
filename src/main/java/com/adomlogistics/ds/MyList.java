package com.adomlogistics.ds;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }
    public void remove(int index) {
        data.remove(index);
    }
    public T get(int index) {
        return data.get(index);
    }
    public int size() {
        return data.size();
    }
    public List<T> toList() {
        return new ArrayList<>(data);
    }
}
