package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_0824_Goat_Latin {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        for (String w : sentence.split("\\s")) {
            res.append(' ').append(vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)).append("ma");
            for (j = 0, ++i; j < i; ++j) {
                res.append('a');
            }
        }
        ;
        return res.substring(1);
    }
}
