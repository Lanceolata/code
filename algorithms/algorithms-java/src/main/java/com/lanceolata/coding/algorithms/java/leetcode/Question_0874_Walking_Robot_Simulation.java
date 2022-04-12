package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question_0874_Walking_Robot_Simulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add(help(obstacles[i][0], obstacles[i][1]));
        }
        int res = 0, dir = 0, x = 0, y = 0;
        int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                dir--;
            } else if (commands[i] == -1) {
                dir++;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    String pos = help(x + ds[dir][0], y + ds[dir][1]);
                    if (obs.contains(pos)) {
                        break;
                    }
                    x += ds[dir][0];
                    y += ds[dir][1];
                }
                res = Math.max(res, x * x + y * y);
            }
            if (dir == -1) {
                dir = 3;
            }
            if (dir == 4) {
                dir = 0;
            }
        }
        return res;
    }

    private String help(int x, int y) {
        return x + "#" + y;
    }
}
