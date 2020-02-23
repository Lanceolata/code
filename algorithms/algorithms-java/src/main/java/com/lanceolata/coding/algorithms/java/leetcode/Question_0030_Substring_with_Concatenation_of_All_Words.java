package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0030_Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || s.isEmpty() || words.length == 0) {
            return res;
        }
        Map<String, Integer> map1 = new HashMap<>();
        for (String w : words) {
            if (map1.containsKey(w)) {
                map1.put(w, map1.get(w) + 1);
            } else {
                map1.put(w, 1);
            }
        }
        int n = s.length(), len = words[0].length();
        for (int i = 0; i < len; i++) {
            int left = i, cnt = 0;
            Map<String, Integer> map2 = new HashMap<>();
            for (int j = i; j <= n - len; j += len) {
                String sub = s.substring(j, j + len);
                if (!map1.containsKey(sub)) {
                    left = j + len;
                    cnt = 0;
                    map2.clear();
                } else {
                    cnt++;
                    if (map2.containsKey(sub)) {
                        map2.put(sub, map2.get(sub) + 1);
                    } else {
                        map2.put(sub,1);
                    }
                    while (map1.get(sub) < map2.get(sub)) {
                        String str = s.substring(left, left + len);
                        map2.put(str, map2.get(str) - 1);
                        cnt--;
                        left += len;
                    }
                    if (cnt == words.length) {
                        res.add(left);
                        String str = s.substring(left, left + len);
                        map2.put(str, map2.get(str) - 1);
                        left += len;
                        --cnt;
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> findSubstring_sample(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map1 = new HashMap<>();
        for (String w : words) {
            if (!map1.containsKey(w)) {
                map1.put(w, 0);
            }
            map1.put(w, map1.get(w) + 1);
        }
        int m = words.length, n = words[0].length();
        for (int i = 0; i <= s.length() - (m * n); i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int j = 0;
            for (; j < m; j++) {
                String sub = s.substring(i + j * n, i + j * n + n);
                if (!map1.containsKey(sub)) {
                    break;
                }
                if (!map2.containsKey(sub)) {
                    map2.put(sub, 0);
                }
                map2.put(sub, map2.get(sub) + 1);
                if (map1.get(sub) < map2.get(sub)) {
                    break;
                }
            }
            if (j == m) {
                res.add(i);
            }
        }
        return res;
    }
}
