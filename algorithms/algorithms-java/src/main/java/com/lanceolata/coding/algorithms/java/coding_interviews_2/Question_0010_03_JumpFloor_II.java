package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0010_03_JumpFloor_II {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return 1 << (target - 1);
    }
}
