package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0335_Self_Crossing {
    /**
     *              i-2
     * case 1 : i-1┌─┐
     *             └─┼─>i
     *              i-3
     *
     *                i-2
     * case 2 : i-1 ┌────┐
     *              └─══>┘i-3
     *              i  i-4      (i overlapped i-4)
     *
     * case 3 :    i-4
     *            ┌──┐
     *            │i<┼─┐
     *         i-3│ i-5│i-1
     *            └────┘
     *             i-2
     */
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) {
            return false;
        }
        for (int i = 3; i < x.length; i++) {
            if(x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                // Case 1: current line crosses the line 3 steps ahead of it
                return true;
            } else if(i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                // Case 2: current line crosses the line 4 steps ahead of it
                return true;
            } else if(i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                // Case 3: current line crosses the line 6 steps ahead of it
                return true;
            }
        }
        return false;
    }
}
