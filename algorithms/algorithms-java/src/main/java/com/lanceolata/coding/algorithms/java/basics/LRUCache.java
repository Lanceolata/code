package com.lanceolata.coding.algorithms.java.basics;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> post;
    }

    private Map<K, Node<K, V>> cache;
    private int count;
    private int capacity;
    private Node<K, V> head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.post = this.tail;
        this.tail.pre = this.head;
    }

    public V get(K k) {
        Node<K, V> node = cache.get(k);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K k, V v) {
        Node<K, V> node = cache.get(k);
        if (node != null) {
            node.value = v;
            moveToHead(node);
            return;
        }
        node = new Node<>();
        node.key = k;
        node.value = v;
        cache.put(k, node);
        addNode(node);
        count++;
        if (count > capacity) {
            node = popTail();
            cache.remove(node.key);
        }
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node<K, V> node) {
        head.post.pre = node;
        node.post = head.post;
        head.post = node;
        node.pre = head;
    }

    private void removeNode(Node<K, V> node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private Node<K, V> popTail() {
        Node<K, V> res = tail.pre;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "1");
        cache.put(2, "2");
        System.out.println(cache.get(1));
        cache.put(3, "3");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
