package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0842_Split_Array_into_Fibonacci_Sequence {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>(), cur = new ArrayList<>();
        help(num, 0, cur, res);
        return res;
    }

    private void help(String num, int i, List<Integer> cur, List<Integer> res) {
        if (!res.isEmpty()) {
            return;
        }
        if (i >= num.length() && cur.size() >= 3) {
            res.addAll(cur);
            return;
        }
        for (int j = i; j < num.length(); j++) {
            String s = num.substring(i, j + 1);
            if ((s.length() > 1 && s.charAt(0) == '0') || s.length() > 10) {
                break;
            }
            long n = Long.parseLong(s);
            int len = cur.size();
            if (n > Integer.MAX_VALUE) {
                break;
            }
            if (cur.size() >= 2 && n != (long) cur.get(len - 1) + cur.get(len - 2)) {
                continue;
            }
            cur.add((int) n);
            help(num, j + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
