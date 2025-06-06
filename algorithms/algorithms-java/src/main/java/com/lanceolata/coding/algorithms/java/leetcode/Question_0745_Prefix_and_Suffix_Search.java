package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0745_Prefix_and_Suffix_Search {

    static class TrieNode {
        TrieNode[] children;
        int weight;

        public TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }

    private TrieNode trie;

    public Question_0745_Prefix_and_Suffix_Search(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; ++weight) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); ++i) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; ++j) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null) {
                        cur.children[k] = new TrieNode();
                    }
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }

    public int f(String pref, String suff) {
        TrieNode cur = trie;
        for (char letter : (suff + '{' + pref).toCharArray()) {
            if (cur.children[letter - 'a'] == null) {
                return -1;
            }
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}
