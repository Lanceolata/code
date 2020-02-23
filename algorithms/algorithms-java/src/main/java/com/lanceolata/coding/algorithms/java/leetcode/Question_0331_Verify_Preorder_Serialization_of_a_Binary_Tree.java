package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) {
            return false;
        }
        int cnt = 0;
        String[] nodes = preorder.split(",");
        for (int i = 0; i < nodes.length - 1; i++) {
            if ("#".equals(nodes[i])) {
                if (cnt == 0) {
                    return false;
                }
                --cnt;
            } else {
                ++cnt;
            }
        }
        return cnt == 0 && "#".equals(nodes[nodes.length - 1]);
    }
}
