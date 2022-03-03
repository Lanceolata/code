package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0733_Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        help(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    private void help(int[][] image, int r, int c, int newColor, int v, boolean[][] visited) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != v || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        image[r][c] = newColor;
        help(image, r - 1, c, newColor, v, visited);
        help(image, r + 1, c, newColor, v, visited);
        help(image, r, c - 1, newColor, v, visited);
        help(image, r, c + 1, newColor, v, visited);
    }
}
