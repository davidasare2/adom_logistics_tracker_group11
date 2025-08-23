package com.adomlogistics.datastructures;

public class MyStack<T> {
	private MyList<T> list = new MyList<>();

	public void push(T item) {
		// Add to end for stack (LIFO)
		list.add(item);
	}

	public T pop() {
		if (list.size() == 0) throw new RuntimeException("Stack is empty");
		T item = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return item;
	}

	public T peek() {
		if (list.size() == 0) throw new RuntimeException("Stack is empty");
		return list.get(list.size() - 1);
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public int size() {
		return list.size();
	}
}
