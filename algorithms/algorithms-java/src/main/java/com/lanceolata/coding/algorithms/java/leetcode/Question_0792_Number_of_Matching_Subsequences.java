package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0792_Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<int[]>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<>());
        }
        for (int i = 0; i < words.length; i++) {
            map.get(words[i].charAt(0)).offer(new int[]{i, 0});
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            Queue<int[]> q = map.get(c);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                if (arr[1] + 1 >= words[arr[0]].length()) {
                    res++;
                } else {
                    map.get(words[arr[0]].charAt(arr[1] + 1)).offer(new int[]{arr[0], arr[1] + 1});
                }
            }
        }
        return res;
    }
}
