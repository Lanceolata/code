package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0735_Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                list.add(asteroids[i]);
            } else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                list.add(asteroids[i]);
            } else if (list.get(list.size() - 1) <= -asteroids[i]) {
                if (list.get(list.size() - 1) < -asteroids[i]) {
                    --i;
                }
                list.remove(list.size() - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
