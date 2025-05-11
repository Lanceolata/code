package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_0749_Contain_Virus {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static class Region {
        Set<Integer> infected = new HashSet<>();
        Set<Integer> unInfected = new HashSet<>();
        int walls = 0;
    }

    public int containVirus(int[][] isInfected) {
        int ans = 0;
        int re = isInfected.length;
        int ce = isInfected[0].length;

        while (true) {
            List<Region> holder = new ArrayList<>();
            boolean[][] v = new boolean[re][ce];
            for (int r = 0; r < re; r++) {
                for (int c = 0; c < ce; c++) {
                    if (isInfected[r][c] == 1 && !v[r][c]) {
                        Region region = new Region();
                        getRegion(isInfected, region, re, ce, v, r, c);
                        holder.add(region);
                    }
                }
            }
            int indexOfMaxUnInfected = 0;
            int sizeOfMaxUnInfected = 0;
            for (int i = 0; i < holder.size(); i++) {
                Region region = holder.get(i);

                if (region.unInfected.size() > sizeOfMaxUnInfected) {
                    sizeOfMaxUnInfected = region.unInfected.size();
                    indexOfMaxUnInfected = i;
                }
            }
            if (holder.size() == 0) {
                break;
            }
            Set<Integer> maxSet = holder.get(indexOfMaxUnInfected).infected;
            for (int rowCol : maxSet) {
                int r = rowCol / ce;
                int c = rowCol % ce;
                isInfected[r][c] = 2;
            }
            ans += holder.get(indexOfMaxUnInfected).walls;
            for (int i = 0; i < holder.size(); i++) {

                if (i == indexOfMaxUnInfected) {
                    continue;
                }
                Region region = holder.get(i);
                Set<Integer> unInfected = region.unInfected;

                for (int rowCol : unInfected) {
                    int r = rowCol / ce;
                    int c = rowCol % ce;
                    isInfected[r][c] = 1;
                }
            }
        }
        return ans;
    }

    private void getRegion(int[][] isInfected, Region region, int re, int ce,
                           boolean[][] v, int r, int c) {
        if (r < 0 || c < 0 || r == re || c == ce || isInfected[r][c] == 2) {
            return;
        }
        if (isInfected[r][c] == 1) {
            if (v[r][c]) {
                return;
            }
            region.infected.add(r * ce + c);
        }
        if (isInfected[r][c] == 0) {
            region.unInfected.add(r * ce + c);
            region.walls++;
            return;
        }
        v[r][c] = true;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            getRegion(isInfected, region, re, ce, v, nr, nc);
        }
    }
}
