package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0730_Count_Different_Palindromic_Subsequences {
    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            long sum = 0;
            int[] map = new int[26];

            for (int j = i - 1; j >= 0; j--) {
                // dp[j] before = number of palindrome between j ... i-1
                // dp[j] after = number of palindrome between j ... i
                // sum = number of palindrome between j+1 ... i-1
                int prev = dp[j];
                if (chars[i] == chars[j]) {
                    dp[j] = (int) ((sum + 2) % mod);
                }
                sum += prev - map[chars[j] - 'a'];
                map[chars[j] - 'a'] = prev;
            }
        }
        //dp[i]  the number of palindrome  sequence from ith character to the end which start at ith character.
        int[] nums = new int[26];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[chars[i] - 'a'] == 0) {
                nums[chars[i] - 'a'] = dp[i];
                sum += dp[i];
            }
        }
        return (int) (sum % mod);
    }
}
