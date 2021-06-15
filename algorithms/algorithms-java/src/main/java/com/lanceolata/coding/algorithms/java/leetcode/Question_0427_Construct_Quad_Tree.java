package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0427_Construct_Quad_Tree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
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
            boolean v = topLeft.val;
            return new Node(v, true, null, null, null, null);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
