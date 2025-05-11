package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0679_24_Game {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        double[] cardsD = new double[]{cards[0], cards[1], cards[2], cards[3]};
        return helper(cardsD);
    }

    private boolean helper(double[] arr) {
        int n = arr.length;
        if (n == 1) {
            // check if equal to 24
            return Math.abs(arr[0] - 24) < 0.0001;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // after picking i and j elem and doing a computation, array of 4 elem becomes array of 3
                // compute(x,y) = z ...evaluates to one result
                double[] d = new double[n - 1];

                // fill up all elements in d other than the chosen i and j
                for (int k = 0, index = 0; k < n; k++) {
                    if (k != i && k != j) {
                        d[index] = arr[k];
                        index++;
                    }
                }

                // last elem of d should contain the computed result of picked elems at i and j
                // d[d.length-1]
                for (double num : compute(arr[i], arr[j])) {
                    d[d.length - 1] = num;
                    // d has been completed succesfully , now check this
                    if (helper(d)) return true;
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};
    }
}
