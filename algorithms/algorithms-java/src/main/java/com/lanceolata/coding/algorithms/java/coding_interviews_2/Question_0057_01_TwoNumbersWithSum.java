package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;

public class Question_0057_01_TwoNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null) {
            return res;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int num = array[l] + array[r];
            if (num == sum) {
                res.add(array[l]);
                res.add(array[r]);
                break;
            } else if (num < sum) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
