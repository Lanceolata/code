package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0551_Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        if (s == null) {
            return true;
        }
        int cl = 0, ca = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                if (++cl > 2) {
                    return false;
                }
                continue;
            }
            if (c == 'A') {
                ca++;
            }
            cl = 0;
        }
        return ca < 2;
    }
}
