package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0599_Minimum_Index_Sum_of_Two_Lists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int sum = list1.length + list2.length, tmp;
        for (int j = 0; j < list2.length && j <= sum; j++) {
            if (!map.containsKey(list2[j])) {
                continue;
            }
            tmp = j + map.get(list2[j]);
            if (tmp > sum) {
                continue;
            }
            if (tmp < sum) {
                res.clear();
                sum = tmp;
            }
            res.add(list2[j]);
        }
        return res.toArray(new String[0]);
    }
}
