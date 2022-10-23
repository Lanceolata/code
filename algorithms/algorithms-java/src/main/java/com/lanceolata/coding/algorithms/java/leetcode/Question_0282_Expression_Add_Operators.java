package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0282_Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0) {
            return res;
        }
        help(num, target, 0, 0, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void help(String num, int target, int i, long pre, long cur, long v, List<String> ops, List<String> res) {
        if (i == num.length()) {
            if (v == target && cur == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(s -> sb.append(s));
                res.add(sb.toString());
            }
            return;
        }

        cur = cur * 10 + Character.getNumericValue(num.charAt(i));
        String curStr = String.valueOf(cur);
        if (cur > 0) {
            help(num, target, i + 1, pre, cur, v, ops, res);
        }

        ops.add("+");
        ops.add(curStr);
        help(num, target, i + 1, cur, 0, v + cur, ops, res);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            ops.add("-");
            ops.add(curStr);
            help(num, target, i + 1, -cur, 0, v - cur, ops, res);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            ops.add("*");
            ops.add(curStr);
            help(num, target, i + 1, cur * pre, 0, v - pre + (cur * pre), ops, res);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }
}
