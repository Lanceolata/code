package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;

public class Question_0460_LFU_Cache {

    public static class Node {
        private int key;
        private int val;
        private int count;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    public static class DLList {
        private Node head;
        private Node tail;
        private int size;

        public DLList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private HashMap<Integer, Node> map;
    private HashMap<Integer, DLList> freqmap;
    private int capacity;
    private int min;

    public Question_0460_LFU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqmap = new HashMap<>();
        min = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node mfu = map.get(key);
        updateNode(mfu);

        return mfu.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node mfu = map.get(key);
            mfu.val = value;
            updateNode(mfu);
        } else {
            if (this.capacity == map.size()) {
                DLList minList = freqmap.get(min);
                Node lru = minList.tail.prev;
                minList.removeNode(lru);
                map.remove(lru.key);
            }

            Node mfu = new Node(key, value);
            map.put(key, mfu);
            min = 1;

            if (!freqmap.containsKey(min)) {
                freqmap.put(min, new DLList());
            }
            freqmap.get(min).addToHead(mfu);
        }
    }

    private void updateNode(Node node) {
        int oldf = node.count;
        DLList oldlist = freqmap.get(oldf);
        oldlist.removeNode(node);
        if (min == oldf && oldlist.size == 0) {
            min++;
        }

        node.count++;

        if (!freqmap.containsKey(node.count)) {
            freqmap.put(node.count, new DLList());
        }
        freqmap.get(node.count).addToHead(node);
    }

}
