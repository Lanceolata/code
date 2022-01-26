package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0609_Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] files = p.split(" ");
            for (int i = 1; i < files.length; i++) {
                int index1 = files[i].indexOf('(');
                String name = files[i].substring(0, index1);
                String content = files[i].substring(index1);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(files[0] + "/" + name);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}
