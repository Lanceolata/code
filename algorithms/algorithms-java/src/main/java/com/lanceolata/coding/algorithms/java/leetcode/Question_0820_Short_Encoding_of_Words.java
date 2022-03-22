package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0820_Short_Encoding_of_Words {
    static class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode(), cur;
        for (String word : words) {
            cur = root;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
        }
        return help(root, 0);
    }

    private int help(TrieNode root, int len) {
        if (root.count == 0) {
            return len + 1;
        }
        int res = 0;
        for (TrieNode p : root.children) {
            if (p != null) {
                res += help(p, len + 1);
            }
        }
        return res;
    }
}
