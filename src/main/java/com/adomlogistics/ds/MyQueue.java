package com.adomlogistics.ds;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        return queue.removeFirst();
    }

    public T peek() {
        if (queue.isEmpty()) throw new NoSuchElementException();
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public LinkedList<T> toList() {
        return new LinkedList<>(queue);
    }
}
