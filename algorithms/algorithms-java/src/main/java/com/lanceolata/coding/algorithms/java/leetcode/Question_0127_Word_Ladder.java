package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_0127_Word_Ladder {
    /*
     * the idea is using two way bfs, as it really does not matter which size is
     * begin and end but if one side getting larger and larger it could become very
     * slow first, we can put the beginword and endword into two set, start from the
     * begin set, get all the neighbor of all the words in the begin set, into a
     * newBegin set update the level + 1; then if the newBegin.size greater then
     * end.size, swap them when calling the helper fucntion.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> bank = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>(Arrays.asList(beginWord));
        Set<String> end = new HashSet<>(Arrays.asList(endWord));
        if (!bank.contains(endWord))
            return 0;
        return help(end, begin, bank, 1);
    }

    public int help(Set<String> begin, Set<String> end, Set<String> bank, int level) {
        if (begin.size() == 0) {
            return 0;
        }
        ++level;
        Set<String> newBegin = new HashSet<>();
        for (String s : begin) {
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; ++i) {
                char tem = c[i];
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    c[i] = ch;
                    if (c[i] != tem) {
                        String curr = new String(c);
                        if (end.contains(curr)) {
                            return level;
                        }
                        if (bank.contains(curr)) {
                            newBegin.add(curr);
                            bank.remove(curr);
                        }
                    }
                }
                c[i] = tem;
            }
        }
        return newBegin.size() > end.size() ? help(end, newBegin, bank, level) : help(newBegin, end, bank, level);
    }
}
