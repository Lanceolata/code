package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0398_Random_Pick_Index {
    private Random random;
    private Map<Integer, List<Integer>> map;

    public Question_0398_Random_Pick_Index(int[] nums) {
        this.random = new Random();
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        int index = random.nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
}
