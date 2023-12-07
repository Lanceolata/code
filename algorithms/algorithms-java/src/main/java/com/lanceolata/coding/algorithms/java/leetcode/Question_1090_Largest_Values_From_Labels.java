package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Question_1090_Largest_Values_From_Labels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] valLab = new int[values.length][2];
        // creating a 2D array which has values and labels corresponding to the values
        for (int i = 0; i < values.length; i++) {
            valLab[i][0] = values[i];
            valLab[i][1] = labels[i];
        }
        // sorting the array in descending order based on the values from column 0
        Arrays.sort(valLab, new Comparator<int[]>() {
            public int compare(final int[] entry1, final int[] entry2) {
                return entry1[0] < entry2[0] ? 1 : -1;
            }
        });

        // create a hashmap for maintaining the useLimit of each label group
        Map<Integer, Integer> hashLabel = new HashMap<>();
        for (int i : labels) {
            hashLabel.put(i, 0);
        }

        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            int val = valLab[i][0];
            int lab = valLab[i][1];
            // if label usage less than use_limit and subset size is less than num_wanted, include array item in the subset
            if (numWanted > 0 && hashLabel.get(lab) < useLimit) {
                sum += val;
                hashLabel.put(lab, hashLabel.get(lab) + 1);
                numWanted--;
            }
        }

        return sum;
    }
}
