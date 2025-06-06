package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0664_Strange_Printer {
    public int strangePrinter(String s) {
        // Preprocess the string to remove consecutive duplicate characters
        s = removeDuplicates(s);

        int n = s.length();

        // dp[i][j] represents the minimum number of turns to print s[i] to s[j]
        int[][] minTurns = new int[n][n];

        // Initialize base case
        for (int i = 0; i < n; i++) {
            // It takes 1 turn to print a single character
            minTurns[i][i] = 1;
        }

        // Fill the dp table
        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;

                // Initialize with worst case: print each character separately
                minTurns[start][end] = length;

                // Try all possible splits and find the minimum
                for (int split = 0; split < length - 1; split++) {
                    int totalTurns =
                            minTurns[start][start + split] +
                                    minTurns[start + split + 1][end];

                    // If the characters at the split and end match, we can save one turn
                    if (s.charAt(start + split) == s.charAt(end)) {
                        totalTurns--;
                    }

                    minTurns[start][end] = Math.min(
                            minTurns[start][end],
                            totalTurns
                    );
                }
            }
        }

        // Return the minimum turns needed to print the entire string
        return minTurns[0][n - 1];
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive occurrences of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}
