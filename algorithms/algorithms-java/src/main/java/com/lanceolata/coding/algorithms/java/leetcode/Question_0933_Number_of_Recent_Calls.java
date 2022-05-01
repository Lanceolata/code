package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.LinkedList;

public class Question_0933_Number_of_Recent_Calls {
    private LinkedList<Integer> slideWindow;

    public Question_0933_Number_of_Recent_Calls() {
        this.slideWindow = new LinkedList<>();
    }

    public int ping(int t) {
        slideWindow.addLast(t);
        while (slideWindow.getFirst() < t - 3000) {
            slideWindow.removeFirst();
        }
        return slideWindow.size();
    }
}
