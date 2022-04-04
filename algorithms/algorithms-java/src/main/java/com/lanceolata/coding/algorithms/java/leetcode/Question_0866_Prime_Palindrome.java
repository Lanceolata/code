package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0866_Prime_Palindrome {
    public int primePalindrome(int n) {
        if (8 <= n && n <= 11) {
            return 11;
        }
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString();
            int y = Integer.parseInt(s + r.substring(1));
            if (y >= n && isPrime(y)) {
                return y;
            }
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) {
            return x == 2;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
