package com.lanceolata.coding.algorithms.java.basics.tree;

import java.util.Arrays;

public class SegmentTree {
    private int size;
    private int[] tree;

    public SegmentTree(int size) {
        this.size = size;
        this.tree = new int[2 * size - 1];
        Arrays.fill(this.tree, 0);
    }
}
