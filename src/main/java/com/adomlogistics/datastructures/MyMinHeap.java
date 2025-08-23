package com.adomlogistics.datastructures;

@SuppressWarnings("unchecked")
public class MyMinHeap<T extends Comparable<T>> {
	private T[] heap;
	private int size = 0;
	private int capacity = 32;

	public MyMinHeap() {
		heap = (T[]) new Comparable[capacity];
	}

	public void insert(T value) {
		if (size == capacity) resize();
		heap[size] = value;
		siftUp(size);
		size++;
	}

	public T extractMin() {
		if (size == 0) throw new RuntimeException("Heap is empty");
		T min = heap[0];
		heap[0] = heap[--size];
		heap[size] = null;
		siftDown(0);
		return min;
	}

	public T peek() {
		if (size == 0) throw new RuntimeException("Heap is empty");
		return heap[0];
	}

	public int size() {
		return size;
	}

	private void siftUp(int idx) {
		while (idx > 0) {
			int parent = (idx - 1) / 2;
			if (heap[idx].compareTo(heap[parent]) < 0) {
				T tmp = heap[idx];
				heap[idx] = heap[parent];
				heap[parent] = tmp;
				idx = parent;
			} else break;
		}
	}

	private void siftDown(int idx) {
		while (2 * idx + 1 < size) {
			int left = 2 * idx + 1, right = 2 * idx + 2, smallest = left;
			if (right < size && heap[right].compareTo(heap[left]) < 0) smallest = right;
			if (heap[smallest].compareTo(heap[idx]) < 0) {
				T tmp = heap[idx];
				heap[idx] = heap[smallest];
				heap[smallest] = tmp;
				idx = smallest;
			} else break;
		}
	}

	private void resize() {
		capacity *= 2;
		T[] newHeap = (T[]) new Comparable[capacity];
		for (int i = 0; i < size; i++) newHeap[i] = heap[i];
		heap = newHeap;
	}
}
