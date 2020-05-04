package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0481_Magical_String {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int res = 1, head = 2, tail = 3, num = 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        while (tail < n) {
            for (int i = 0; i < list.get(head); ++i) {
                list.add(num);
                if (num == 1 && tail < n) {
                    ++res;
                }
                ++tail;
            }
            num ^= 3;
            ++head;
        }
        return res;
    }
}
