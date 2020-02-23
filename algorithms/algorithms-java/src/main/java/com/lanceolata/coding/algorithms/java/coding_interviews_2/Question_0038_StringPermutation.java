package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;
import java.util.TreeSet;

public class Question_0038_StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        TreeSet<String> temp = new TreeSet<>();
        help(str.toCharArray(), 0, temp);
        res.addAll(temp);
        return res;
    }

    private void help(char[] chars, int i, TreeSet<String> res) {
        if (i >= chars.length) {
            res.add(new String(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            help(chars, i + 1, res);
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
