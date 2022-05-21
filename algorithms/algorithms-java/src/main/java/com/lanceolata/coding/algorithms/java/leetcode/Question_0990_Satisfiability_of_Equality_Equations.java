package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0990_Satisfiability_of_Equality_Equations {
    private int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) {
            uf[i] = i;
        }
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (x != uf[x]) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}
