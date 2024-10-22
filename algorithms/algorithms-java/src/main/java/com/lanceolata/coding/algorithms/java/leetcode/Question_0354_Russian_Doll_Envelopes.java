package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Question_0354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        // If there are less than 2 envelopes, return the number of envelopes.
        if (n < 2) {
            return n;
        }

        // Sort envelopes based on the width in ascending order.
        // If the widths are equal, sort by height in descending order.
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        // Dynamic programming array to store the maximum height for increasing width sequences.
        int dp[] = new int[n];
        dp[0] = envelopes[0][1];
        int len = 1;

        // Iterate through the sorted envelopes.
        for (int i = 1; i < n; i++) {
            // If the current envelope height is greater than the previous maximum height,
            // extend the increasing sequence and update the maximum height.
            if (dp[len - 1] < envelopes[i][1]) {
                dp[len++] = envelopes[i][1];
            } else {
                // Use binary search to find the correct position for the current envelope height
                // in the increasing sequence and update the dynamic programming array.
                int idx = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                dp[idx] = envelopes[i][1];
            }
        }

        // Return the length of the longest increasing subsequence.
        return len;
    }
}
