package com.adomlogistics.datastructures;

public class MyTree<T extends Comparable<T>> {
	private static class Node<T> {
		T data;
		Node<T> left, right;
		Node(T data) { this.data = data; }
	}

	private Node<T> root;
	private int size = 0;

	public void insert(T value) {
		root = insertRec(root, value);
		size++;
	}

	private Node<T> insertRec(Node<T> node, T value) {
		if (node == null) return new Node<>(value);
		if (value.compareTo(node.data) < 0) node.left = insertRec(node.left, value);
		else node.right = insertRec(node.right, value);
		return node;
	}

	public boolean contains(T value) {
		return containsRec(root, value);
	}

	private boolean containsRec(Node<T> node, T value) {
		if (node == null) return false;
		if (value.compareTo(node.data) == 0) return true;
		if (value.compareTo(node.data) < 0) return containsRec(node.left, value);
		else return containsRec(node.right, value);
	}

	public int size() {
		return size;
	}
}
