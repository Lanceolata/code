package com.lanceolata.coding.algorithms.java.basics.tree;

public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.contains(c)) {
                p.createChild(c);
            }
            p = p.get(c);
        }
        p.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.contains(c)) {
                return false;
            }
            p = p.get(c);
        }
        return p.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!p.contains(c)) {
                return false;
            }
            p = p.get(c);
        }
        return true;
    }

    class TrieNode {
        private static final int LEN = 26;
        private TrieNode[] child;
        private boolean isEnd;

        public TrieNode() {
            child = new TrieNode[LEN];
        }

        public boolean contains(char c) {
            return child[c - 'a'] != null;
        }

        private void createChild(char c) {
            child[c - 'a'] = new TrieNode();
        }

        private TrieNode get(char c) {
            return child[c - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }
}
