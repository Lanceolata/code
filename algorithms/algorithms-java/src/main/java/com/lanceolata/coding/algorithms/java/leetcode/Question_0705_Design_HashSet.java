package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question_0705_Design_HashSet {
    private int prime;
    private List<List<Integer>> table;

    public Question_0705_Design_HashSet() {
        this.prime = 10007;
        this.table = new ArrayList<>(prime);
        for (int i = 0; i < this.prime; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int h = hash(key);
        table.get(h).add(key);
    }

    public void remove(int key) {
        int h = hash(key);
        int index = table.get(h).indexOf(key);
        if (index >= 0) {
            table.get(h).remove(index);
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        return table.get(h).contains(key);
    }

    private int hash(int key) {
        return key % prime;
    }
}
