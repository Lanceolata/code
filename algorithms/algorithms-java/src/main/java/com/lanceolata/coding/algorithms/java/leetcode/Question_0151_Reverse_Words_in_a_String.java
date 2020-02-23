package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Question_0151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
