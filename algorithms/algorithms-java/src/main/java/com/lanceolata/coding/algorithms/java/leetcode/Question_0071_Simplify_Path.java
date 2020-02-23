package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_0071_Simplify_Path {
    public String simplifyPath(String path) {
        if (path == null) {
            return path;
        }
        String[] items = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : items) {
            if (item.isEmpty() || item.equals(".")) {
                continue;
            } else if (item.equals("..")) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else {
                stack.push(item);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        List<String> list = new ArrayList<>(stack);
        // 注意添加"/"
        return "/" + String.join("/", list);
    }
}
