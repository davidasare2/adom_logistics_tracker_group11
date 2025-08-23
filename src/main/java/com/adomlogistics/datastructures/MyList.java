package com.adomlogistics.datastructures;

public class MyList<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) { this.data = data; }
	}

	private Node<T> head;
	private int size = 0;

	public void add(T item) {
		Node<T> newNode = new Node<>(item);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> curr = head;
			while (curr.next != null) curr = curr.next;
			curr.next = newNode;
		}
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> curr = head;
			for (int i = 0; i < index - 1; i++) curr = curr.next;
			curr.next = curr.next.next;
		}
		size--;
	}

	public T get(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		Node<T> curr = head;
		for (int i = 0; i < index; i++) curr = curr.next;
		return curr.data;
	}

	public int size() {
		return size;
	}

	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<T> curr = head;
		int i = 0;
		while (curr != null) {
			arr[i++] = curr.data;
			curr = curr.next;
		}
		return arr;
	}
	public java.util.List<T> toList() {
		java.util.List<T> result = new java.util.ArrayList<>();
		Node<T> curr = head;
		while (curr != null) {
			result.add(curr.data);
			curr = curr.next;
		}
		return result;
	}
}
