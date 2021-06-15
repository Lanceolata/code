package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0433_Minimum_Genetic_Mutation {
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] arr = cur.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c : charSet) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
