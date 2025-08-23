package com.adomlogistics.datastructures;

public class MyQueue<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) { this.data = data; }
	}

	private Node<T> head, tail;
	private int size = 0;

	public void enqueue(T item) {
		Node<T> newNode = new Node<>(item);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public T dequeue() {
		if (size == 0) throw new RuntimeException("Queue is empty");
		T item = head.data;
		head = head.next;
		if (head == null) tail = null;
		size--;
		return item;
	}

	public T peek() {
		if (size == 0) throw new RuntimeException("Queue is empty");
		return head.data;
	}

	public boolean isEmpty() {
		return size == 0;
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
