package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0855_Exam_Room {
    private int N;
    private List<Integer> L;

    public Question_0855_Exam_Room(int n) {
        this.N = n;
        this.L = new ArrayList<>();
    }

    public int seat() {
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
        for (int i = 1; i < L.size(); ++i) {
            d = Math.max(d, (L.get(i) - L.get(i - 1)) / 2);
        }
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        for (int i = 1; i < L.size(); i++) {
            if ((L.get(i) - L.get(i - 1)) / 2 == d) {
                L.add(i, (L.get(i) + L.get(i - 1)) / 2);
                return L.get(i);
            }
        }
        L.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < L.size(); ++i) {
            if (L.get(i) == p) {
                L.remove(i);
            }
        }
    }
}
