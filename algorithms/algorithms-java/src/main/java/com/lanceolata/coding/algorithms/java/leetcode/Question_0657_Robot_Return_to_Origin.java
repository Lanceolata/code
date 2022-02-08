package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return true;
        }
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                y--;
            } else if (c == 'R') {
                y++;
            } else if (c == 'U') {
                x++;
            } else if (c == 'D') {
                x--;
            }
        }
        return x == 0 && y == 0;
    }
}
