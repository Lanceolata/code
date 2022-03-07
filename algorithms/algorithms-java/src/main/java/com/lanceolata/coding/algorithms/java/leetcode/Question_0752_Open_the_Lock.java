package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0752_Open_the_Lock {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> deadlock = new HashSet<>(Arrays.asList(deadends));
        if (deadlock.contains("0000")) {
            return -1;
        }
        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            res++;
            for (int k = queue.size(); k > 0; k--) {
                char[] arr = queue.poll().toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    arr[i] = c == '9' ? '0' : (char) (c + 1);
                    if (help(target, new String(arr), deadlock, visited, queue)) {
                        return res;
                    }
                    arr[i] = c == '0' ? '9' : (char) (c - 1);
                    if (help(target, new String(arr), deadlock, visited, queue)) {
                        return res;
                    }
                    arr[i] = c;
                }
            }
        }
        return -1;
    }

    private boolean help(String target, String s, Set<String> deadlock, Set<String> visited, Queue<String> queue) {
        if (target.equals(s)) {
            return true;
        }
        if (!visited.contains(s) && !deadlock.contains(s)){
            visited.add(s);
            queue.offer(s);
        }
        return false;
    }
}
