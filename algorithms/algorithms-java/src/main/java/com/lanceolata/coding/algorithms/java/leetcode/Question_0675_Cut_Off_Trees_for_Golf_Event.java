package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question_0675_Cut_Off_Trees_for_Golf_Event {
    private static final int TREE_HEIGHT_INDEX = 2;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // Up, Down, Left, Right
    private int rows;
    private int cols;

    public int cutOffTree(List<List<Integer>> forest) {
        rows = forest.size();
        cols = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int xCord = 0; xCord < rows; xCord++) {
            for (int yCord = 0; yCord < cols; yCord++) {
                int height = forest.get(xCord).get(yCord);
                if (height > 1) {
                    trees.add(new int[]{xCord, yCord, height});
                }
            }
        }

        trees.sort((tree1, tree2) -> tree1[TREE_HEIGHT_INDEX] - tree2[TREE_HEIGHT_INDEX]);

        int startRow = 0, startCol = 0;
        int totalSteps = 0;

        for (int[] tree : trees) {
            int steps = bfs(forest, startRow, startCol, tree[0], tree[1]);
            if (steps == -1) return -1;
            totalSteps += steps;
            startRow = tree[0];
            startCol = tree[1];
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startRow, int startCol, int targetRow, int targetCol) {
        if (startRow == targetRow && startCol == targetCol) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if (isValid(newRow, newCol) && !visited[newRow][newCol] && forest.get(newRow).get(newCol) != 0) {
                        if (newRow == targetRow && newCol == targetCol) {
                            return steps;
                        }

                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int col) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
}
