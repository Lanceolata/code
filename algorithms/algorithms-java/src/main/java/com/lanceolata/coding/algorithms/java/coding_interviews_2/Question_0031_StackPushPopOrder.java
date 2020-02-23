package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.Stack;

public class Question_0031_StackPushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < popA.length) {
            while (i < pushA.length && (stack.isEmpty() || stack.peek() != popA[j])) {
                stack.push(pushA[i++]);
            }
            if (stack.peek() != popA[j]) {
                return false;
            }
            stack.pop();
            j++;
        }
        return true;
    }
}
