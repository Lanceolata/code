package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Question_0380_Insert_Delete_GetRandom_O1 {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> m;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public Question_0380_Insert_Delete_GetRandom_O1() {
        nums = new ArrayList<Integer>();
        m = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }
        nums.add(val);
        m.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }
        int last = nums.get(nums.size() - 1);
        m.put(last, m.get(val));
        nums.set(m.get(val), last);
        nums.remove(nums.size() - 1);
        m.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
