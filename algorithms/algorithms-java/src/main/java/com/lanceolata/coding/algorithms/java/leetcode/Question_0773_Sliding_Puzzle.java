package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question_0773_Sliding_Puzzle {
    public int slidingPuzzle(int[][] board) {
        // Direction map for zero's possible moves in a 1D representation of the 2x3 board
        int[][] directions = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4},
        };

        String target = "123450";
        StringBuilder startState = new StringBuilder();

        // Convert the 2D board into a string representation
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startState.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>(); // To store visited states
        Queue<String> queue = new LinkedList<>();
        queue.add(startState.toString());
        visited.add(startState.toString());

        int moves = 0;

        // BFS to find the minimum number of moves
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentState = queue.poll();

                // Check if we reached the target solved state
                if (currentState.equals(target)) {
                    return moves;
                }

                int zeroPos = currentState.indexOf('0');
                for (int newPos : directions[zeroPos]) {
                    String nextState = swap(currentState, zeroPos, newPos);

                    // Skip if this state has been visited
                    if (visited.contains(nextState)) {
                        continue;
                    }

                    // Mark the new state as visited and add it to the queue
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
            moves++;
        }
        return -1;
    }

    // Helper method to swap characters at indices i and j in the string
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
