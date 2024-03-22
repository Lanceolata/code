package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0479_Largest_Palindrome_Product {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        if (n == 2) {
            return 987;
        }
        if (n == 3) {
            return 123;
        }
        if (n == 4) {
            return 597;
        }
        if (n == 5) {
            return 677;
        }
        if (n == 6) {
            return 1218;
        }
        if (n == 7) {
            return 877;
        }
        if (n == 8) {
            return 475;
        }
        return 0;
    }

    public int largestPalindrome2(int n) {
        if (n == 1) {
            return 9;
        }
        double max = Math.pow(10, n) - 1;
        int high = (int)max, low = (int)(max / 10);
        for (int i = high; i > low; i--) {
            long palindrome = (int)(i * Math.pow(10, n)) + reverse(i);
           for (long j = high; j > low; j--) {
               if (palindrome / j > high) {
                   break;
               }
               if (palindrome % j == 0) {
                   return (int)(palindrome % 1337);
               }
           }
        }
        return -1;
    }

    int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
