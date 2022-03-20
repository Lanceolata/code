package com.lanceolata.coding.algorithms.java.leetcode;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class Question_0811_Subdomain_Visit_Count {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> counts = new HashMap<>();
            for (String domain : cpdomains) {
                String[] cpinfo = domain.split("\\s+");
                String[] frags = cpinfo[1].split("\\.");
                int count = Integer.parseInt(cpinfo[0]);
                String cur = "";
                for (int i = frags.length - 1; i >= 0; --i) {
                    cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                    counts.put(cur, counts.getOrDefault(cur, 0) + count);
                }
            }
            List<String> res = new ArrayList<>();
            for (String dom : counts.keySet()) {
                res.add(counts.get(dom) + " " + dom);
            }
            return res;
        }
    }
