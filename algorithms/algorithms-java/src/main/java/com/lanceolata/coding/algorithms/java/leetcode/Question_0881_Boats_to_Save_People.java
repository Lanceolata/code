package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0881_Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int res = 0;
        while (i <= j) {
            res++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return res;
    }
}
