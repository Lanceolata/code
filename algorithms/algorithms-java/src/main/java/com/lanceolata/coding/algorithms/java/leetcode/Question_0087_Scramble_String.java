package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0087_Scramble_String {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1+"_"+s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                map.put(key, false);
                return false;
            }
        }
        int n = s1.length();
        for (int i = 1 ; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                map.put(key, true);
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
