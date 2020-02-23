package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0008_NextNodeInBinaryTrees {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }
        TreeLinkNode res = null;
        if (pNode.right != null) {
            res = pNode.right;
            while (res.left!= null) {
                res = res.left;
            }
        } else {
            res = pNode.next;
            while (res != null && res.right == pNode) {
                pNode = res;
                res = res.next;
            }
        }
        return res;
    }
}
