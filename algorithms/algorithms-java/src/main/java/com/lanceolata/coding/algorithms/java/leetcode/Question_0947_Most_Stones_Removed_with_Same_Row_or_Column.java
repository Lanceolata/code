package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0947_Most_Stones_Removed_with_Same_Row_or_Column {
    private Map<Integer, Integer> f = new HashMap<>();
    private int islands = 0;

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - islands;
    }

    private void union(int x, int y) {
        System.out.println("=== " + x + "\t" + y);
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }

    private int find(int x) {
        if (f.putIfAbsent(x, x) == null) {
            islands++;
        }
        if (x != f.get(x)) {
            f.put(x, find(f.get(x)));
        }
        System.out.println(x + "\t" + f.get(x) + "\t" + islands);
        return f.get(x);
    }

    public static void main(String[] args) {
        Question_0947_Most_Stones_Removed_with_Same_Row_or_Column sol = new Question_0947_Most_Stones_Removed_with_Same_Row_or_Column();
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        sol.removeStones(stones);
    }
}
