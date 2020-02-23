package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0299_Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.isEmpty() || guess.isEmpty()
                || secret.length() != guess.length()) {
            return null;
        }
        int[] m = new int[256];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                a++;
            }
            if (m[s]++ < 0) {
                b++;
            }
            if (m[g]-- > 0) {
                b++;
            }
        }
        return a + "A" + (b - a) + "B";
    }
}
