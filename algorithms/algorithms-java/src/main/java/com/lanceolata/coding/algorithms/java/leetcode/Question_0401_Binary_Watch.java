package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0401_Binary_Watch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        if (turnedOn < 0 || turnedOn > 12) {
            return res;
        }
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
}
