package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_0127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> begin = new HashSet<>(Arrays.asList(beginWord));
        Set<String> end = new HashSet<>(Arrays.asList(endWord));
        Set<String> bank = new HashSet<>(wordList);
        if (!bank.contains(endWord)) {
            return 0;
        }
        return help(begin, end, bank, 1);
    }
    
    private int help(Set<String> begin, Set<String> end, Set<String> bank, int level) {
        if (begin.size() == 0) {
            return 0;
        }
        level++;
        Set<String> n = new HashSet<>();
        for (String s : begin) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char t = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != t) {
                        arr[i] = c;
                        String cur = new String(arr);
                        if (end.contains(cur)) {
                            return level;
                        }
                        if (bank.contains(cur)) {
                            n.add(cur);
                            bank.remove(cur);
                        }
                    }
                }
                arr[i] = t;
            }
        }
        return n.size() > end.size() ? help(end, n, bank, level) : help(n, end, bank, level);
    }
}
