package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0427_Construct_Quad_Tree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node construct(int[][] grid) {
        if (grid == null) return null;
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }

        len /= 2;
        Node topLeft = dfs(grid, x, y, len);
        Node topRight = dfs(grid, x, y + len, len);
        Node bottomLeft = dfs(grid, x + len, y, len);
        Node bottomRight = dfs(grid, x + len, y + len, len);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            Boolean v = topLeft.val;
            return new Node(v, true, null, null, null, null);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
