package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0554_Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
                res = Math.max(res, map.get(sum));
            }
        }
        return wall.size() - res;
    }
}
