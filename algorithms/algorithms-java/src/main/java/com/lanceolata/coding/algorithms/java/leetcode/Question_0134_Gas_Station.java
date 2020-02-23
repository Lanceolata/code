package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int total = 0, sum = 0, index = -1;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total >= 0 ? index + 1 : -1;
    }
}
