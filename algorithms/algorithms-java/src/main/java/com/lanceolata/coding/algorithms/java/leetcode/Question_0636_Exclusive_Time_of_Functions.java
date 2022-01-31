package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Question_0636_Exclusive_Time_of_Functions {
    public static class Log {
        public int id;
        public boolean isStart;
        public int time;
        public int subDuration;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.parseInt(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.parseInt(strs[2]);
            subDuration = 0;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Log> stack = new ArrayDeque<>();
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                res[top.id] += (log.time - top.time + 1 - top.subDuration);
                if (!stack.isEmpty()) {
                    stack.peek().subDuration += (log.time - top.time + 1);
                }
            }
        }
        return res;
    }
}
