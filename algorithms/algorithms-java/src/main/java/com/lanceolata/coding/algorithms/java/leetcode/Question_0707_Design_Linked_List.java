package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0707_Design_Linked_List {
    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private int size = 0;
    private Node head = new Node(0);

    public Question_0707_Design_Linked_List() {

    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        Node p = head.next;
        head.next = new Node(val);
        head.next.next = p;
        size++;
    }

    public void addAtTail(int val) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }
}
