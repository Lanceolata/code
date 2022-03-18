package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0804_Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray()) {
                code.append(morse[c - 'a']);
            }
            set.add(code.toString());
        }
        return set.size();
    }
}
