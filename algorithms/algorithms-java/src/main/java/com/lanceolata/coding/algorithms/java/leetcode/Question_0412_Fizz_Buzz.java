package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0412_Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return null;
        }
        int three = 3, five = 5;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            --three;
            --five;
            if (three == 0 && five == 0) {
                res.add("FizzBuzz");
                three = 3;
                five = 5;
            } else if (three == 0) {
                res.add("Fizz");
                three = 3;
            } else if (five == 0) {
                res.add("Buzz");
                five = 5;
            } else {
                res.add(i + "");
            }
        }
        return res;
    }
}
