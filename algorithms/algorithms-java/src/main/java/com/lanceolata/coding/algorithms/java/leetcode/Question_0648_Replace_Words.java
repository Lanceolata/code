package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.List;

public class Question_0648_Replace_Words {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String s : dictionary) {
            TrieNode cur = trie;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (res.length() > 0) {
                res.append(" ");
            }
            TrieNode cur = trie;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            res.append(cur.word != null ? cur.word : word);
        }
        return res.toString();
    }
}
