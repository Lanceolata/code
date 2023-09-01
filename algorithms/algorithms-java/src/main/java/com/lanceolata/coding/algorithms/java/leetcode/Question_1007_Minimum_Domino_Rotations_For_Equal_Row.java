package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1007_Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        for (int i = 0; i < tops.length; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i  = 1; i <= 6; i++) {
            if (countA[i] + countB[i] - same[i] == tops.length) {
                return tops.length - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }
}
