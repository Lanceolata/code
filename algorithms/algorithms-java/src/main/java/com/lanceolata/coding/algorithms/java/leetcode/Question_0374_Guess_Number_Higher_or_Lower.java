package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0374_Guess_Number_Higher_or_Lower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     */
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1, r = n, m, res;
        while (l <= r) {
            m = l + (r - l) / 2;
            res = guess(m);
            if (res == 0) {
                return m;
            } else if (res < 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
