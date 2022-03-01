package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.*;

public class Question_0721_Accounts_Merge {
    private HashSet<String> visited = new HashSet<>();
    /**
     * firstEmail -> email
     * email -> firstEmail
     */
    private Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                if (!adjacent.containsKey(firstEmail)) {
                    adjacent.put(firstEmail, new ArrayList<String>());
                }
                adjacent.get(firstEmail).add(email);

                if (!adjacent.containsKey(email)) {
                    adjacent.put(email, new ArrayList<String>());
                }
                adjacent.get(email).add(firstEmail);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(name);
                dfs(mergedAccount, firstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                res.add(mergedAccount);
            }
        }
        return res;
    }

    private void dfs(List<String> mergedAccount, String email) {
        visited.add(email);
        mergedAccount.add(email);
        if (!adjacent.containsKey(email)) {
            return;
        }
        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(mergedAccount, neighbor);
            }
        }
    }
}
