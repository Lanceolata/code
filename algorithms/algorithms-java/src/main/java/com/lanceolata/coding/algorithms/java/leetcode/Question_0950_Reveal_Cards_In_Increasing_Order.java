package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question_0950_Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            if (q.size() > 0) {
                q.add(q.poll());
            }
            q.add(deck[i]);
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = q.poll();
        }
        return res;
    }
}
