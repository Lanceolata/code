package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0336_Palindrome_Pairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String rvs = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(rvs) && map.get(rvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(rvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (!s2.isEmpty() && isPalindrome(s2)) {
                    String rvs = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(rvs) && map.get(rvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(rvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) !=  s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
