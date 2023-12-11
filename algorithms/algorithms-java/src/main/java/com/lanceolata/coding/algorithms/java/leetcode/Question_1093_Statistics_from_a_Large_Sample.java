package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1093_Statistics_from_a_Large_Sample {
    public double[] sampleStats(int[] count) {
        int l = 0, r = 255, nl = 0, nr = 0, minV = 256, maxV = -1, mid1 = 0, mid2 = 0, mode = 0;
        long sum = 0;
        double mid = 0;
        while (l <= r) {
            while (count[l] == 0) {
                l++;
            }
            while (count[r] == 0) {
                r--;
            }
            if (nl < nr) {
                sum += (long) count[l] * l;
                nl += count[l];
                if (count[l] > count[mode]) {
                    mode = l;
                }
                minV = Math.min(minV, l);
                maxV = Math.max(maxV, l);
                mid1 = l;
                l++;
            } else {
                sum += (long) count[r] * r;
                nr += count[r];
                if (count[r] > count[mode]) {
                    mode = r;
                }
                minV = Math.min(minV, r);
                maxV = Math.max(maxV, r);
                mid2 = r;
                r--;
            }
        }
        if (nl < nr) {
            mid = mid2;
        } else if (nl > nr) {
            mid = mid1;
        } else {
            mid = (double) (mid1 + mid2) / 2;
        }
        return new double[]{minV, maxV, 1.0 * sum / (nl + nr), mid, mode};
    }
}
