package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_0385_Mini_Parser {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger cur = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 1, start = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '[') {
                stack.push(cur);
                cur = new NestedInteger();
                stack.peek().add(cur);
                start = i + 1;
            } else if (s.charAt(i) == ']' || s.charAt(i) == ',') {
                if (start < i) {
                    cur.add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
                }
                start = i + 1;
                if (s.charAt(i) == ']' && !stack.empty()) {
                    cur = stack.pop();
                }
            }
        }
        return cur;
    }

    public NestedInteger deserializeRecursive(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger res = new NestedInteger();
        for (int i = 1, j = 1, cnt = 0; j < s.length() - 1; j++) {
            if (j == s.length() - 2) {
                res.add(deserializeRecursive(s.substring(i, j + 1)));
                i = j + 1;
            } else if (s.charAt(j) == ',' && cnt == 0) {
                res.add(deserializeRecursive(s.substring(i, j)));
                i = j + 1;
            } else if (s.charAt(j) == '[') {
                cnt++;
            } else if (s.charAt(j) == ']') {
                cnt--;
            }
        }
        return res;
    }
}
