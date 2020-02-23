package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0211_Add_and_Search_Word {
    public class TrieNode {
        // R links to node children
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public TrieNode get(int i) {
            return links[i];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Question_0211_Add_and_Search_Word() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchWord(word, root, 0);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean searchWord(String word, TrieNode p, int i) {
        if (i == word.length()) {
            return p.isEnd();
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (p.get(j) != null && searchWord(word, p.get(j), i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (p.containsKey(c)) {
                return searchWord(word, p.get(c), i + 1);
            } else {
                return false;
            }
        }
    }
}
