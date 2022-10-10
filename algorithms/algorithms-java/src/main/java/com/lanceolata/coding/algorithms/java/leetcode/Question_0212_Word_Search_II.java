package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0212_Word_Search_II {
    public class TrieNode {
        // R links to node children
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private String word;

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

        public void unsetEnd() {
            isEnd = false;
        }

        public void setWord(String w) {
            word = w;
        }

        public String getWord() {
            return word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (!p.containsKey(c)) {
                    p.put(c, new TrieNode());
                }
                p = p.get(c);
            }
            p.setEnd();
            p.setWord(w);
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || !p.containsKey(c)) {
            return;
        }
        p = p.get(c);
        if (p.isEnd) {
            res.add(p.getWord());
            p.unsetEnd();
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, p, res);
        dfs(board, i + 1, j, p, res);
        dfs(board, i, j - 1, p, res);
        dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }
}
