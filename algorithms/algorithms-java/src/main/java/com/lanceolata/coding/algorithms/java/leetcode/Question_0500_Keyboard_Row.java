package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0500_Keyboard_Row {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new ArrayList<>();
        for(String w: words){
            if (w.isEmpty()) {
                continue;
            }
            int index = map.get(w.toUpperCase().charAt(0));
            for (char c : w.toUpperCase().toCharArray()) {
                if(map.get(c) != index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if (index != -1) {
                res.add(w);//if index != -1, this is a valid string
            }
        }
        return res.toArray(new String[0]);
    }
}
