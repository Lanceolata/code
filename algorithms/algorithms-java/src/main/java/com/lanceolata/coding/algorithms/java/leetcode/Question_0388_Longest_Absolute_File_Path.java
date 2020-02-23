package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0388_Longest_Absolute_File_Path {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int res = 0, level, cur;
        for(String s : paths){
            // 层数
            level = s.lastIndexOf("\t") + 1;
            // 减去level个\t 增加1个/
            cur = stack[level + 1] = stack[level] + s.length() - level + 1;
            if(s.contains(".")) {
                // - 1 是去掉开始的/
                res = Math.max(res, cur - 1);
            }
        }
        return res;
    }
}
