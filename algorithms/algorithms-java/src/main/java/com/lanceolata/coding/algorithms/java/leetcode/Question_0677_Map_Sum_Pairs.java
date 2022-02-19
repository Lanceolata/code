package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0677_Map_Sum_Pairs {
    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }

    private HashMap<String, Integer> map;
    private TrieNode root;

    public Question_0677_Map_Sum_Pairs() {
        this.map = new HashMap();
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) {
                return 0;
            }
        }
        return cur.score;
    }
}
