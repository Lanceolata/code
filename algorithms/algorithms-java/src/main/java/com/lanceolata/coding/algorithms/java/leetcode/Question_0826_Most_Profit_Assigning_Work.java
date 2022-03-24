package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0826_Most_Profit_Assigning_Work {
    private static class Pair<A, B> {
        public final A key;
        public final B value;

        public Pair(A key, B value) {
            this.key = key;
            this.value = value;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<A, B>(a, b);
        }

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int n = profit.length, res = 0, i = 0, best = 0;
        for (int j = 0; j < n; ++j) {
            jobs.add(Pair.of(difficulty[j], profit[j]));
        }
        jobs.sort(Comparator.comparing(t -> t.getKey()));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < n && ability >= jobs.get(i).getKey()) {
                best = Math.max(jobs.get(i++).getValue(), best);
            }
            res += best;
        }
        return res;
    }
}
