package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Question_0710_Random_Pick_with_Blacklist {

    private int M;
    private Random r;
    private Map<Integer, Integer> map;

    public Question_0710_Random_Pick_with_Blacklist(int n, int[] blacklist) {
        map = new HashMap();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = n - map.size();

        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (map.containsKey(n - 1)) {
                    n--;
                }
                map.put(b, n - 1);
                n--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
}
