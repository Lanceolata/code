package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree1.val) {
            return quadTree1;
        }
        if (quadTree2.isLeaf && quadTree2.val) {
            return quadTree2;
        }
        if(quadTree1.isLeaf && !quadTree1.val) {
            return quadTree2;
        }
        if(quadTree2.isLeaf && !quadTree2.val) {
            return quadTree1;
        }
        Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if(tl.val == tr.val && tl.val == bl.val && tl.val == br.val && tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            return new Node(tl.val, true, null, null, null, null);
        } else {
            return new Node(false, false, tl, tr, bl, br);
        }
    }
}
