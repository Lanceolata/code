package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0722_Remove_Comments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean comment = false;
        for (String s : source) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (!comment && i + 1 < arr.length && arr[i] == '/' && arr[i + 1] == '/') {
                    break;
                }
                if (!comment && i + 1 < arr.length && arr[i] == '/' && arr[i + 1] == '*') {
                    comment = true;
                    i++;
                } else if (comment && i + 1 < arr.length && arr[i] == '*' && arr[i + 1] == '/') {
                    comment = false;
                    i++;
                } else if (!comment) {
                    sb.append(arr[i]);
                }
            }
            if (!comment && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
