package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0720_Longest_Word_in_Dictionary {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private String res;

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTree(word, root);
        }
        res = "";
        dfs(root, 0);
        return res;
    }

    private void buildTree(String word, TrieNode p) {
        for (char c : word.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.word = word;
    }

    private void dfs(TrieNode root, int cnt) {
        cnt++;
        for (TrieNode p : root.children) {
            if (p == null || p.word == null) {
                continue;
            }
            if (cnt > res.length()) {
                res = p.word;
            }
            dfs(p, cnt);
        }
    }
}
