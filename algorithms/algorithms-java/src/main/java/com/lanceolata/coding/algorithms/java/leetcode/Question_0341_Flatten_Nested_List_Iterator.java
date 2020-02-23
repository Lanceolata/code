package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Question_0341_Flatten_Nested_List_Iterator implements Iterator<Integer> {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

    private Stack<NestedInteger> stack;

    public Question_0341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger node = stack.peek();
            if (node.isInteger()) {
                return true;
            }
            stack.pop();
            flatten(node.getList());
        }
        return false;
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}
