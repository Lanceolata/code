package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0014_CuttingRope {
    public int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length <= 3) {
            return length;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int tmp = 0;
        for(int i = 4; i <= length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                tmp = dp[j] * dp[i - j];
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[length];
    }
}
