package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0796_Rotate_String {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
