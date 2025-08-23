package com.adomlogistics.datastructures;

public class MyHashTable<K, V> {
	private static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		Entry(K key, V value) { this.key = key; this.value = value; }
	}

	private final Entry<K, V>[] table;
	private final int capacity = 16;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public MyHashTable() {
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % capacity;
	}

	public void put(K key, V value) {
		int idx = hash(key);
		Entry<K, V> curr = table[idx];
		while (curr != null) {
			if (curr.key.equals(key)) {
				curr.value = value;
				return;
			}
			curr = curr.next;
		}
		Entry<K, V> newEntry = new Entry<>(key, value);
		newEntry.next = table[idx];
		table[idx] = newEntry;
		size++;
	}

	public V get(K key) {
		int idx = hash(key);
		Entry<K, V> curr = table[idx];
		while (curr != null) {
			if (curr.key.equals(key)) return curr.value;
			curr = curr.next;
		}
		return null;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public int size() {
		return size;
	}
}
