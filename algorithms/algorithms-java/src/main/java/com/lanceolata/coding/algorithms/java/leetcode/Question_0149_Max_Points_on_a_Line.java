package com.lanceolata.coding.algorithms.java.leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Objects;

public class Question_0149_Max_Points_on_a_Line {
    private static class Pair<A, B> {
        public final A key;
        public final B value;

        public Pair(A key, B value) {
            this.key = key;
            this.value = value;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<A, B>(a, b);
        }

        public A getKey() {
            return key;
        }

        public B getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private int[][] points;
    private int n;
    private HashMap<Pair<Integer, Integer>, Integer> lines = new HashMap<>();
    private int horizontalLines;

    public int maxPoints(int[][] points) {
        this.points = points;
        n = points.length;
        if (n < 3) {
            return n;
        }
        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(help(i), res);
        }
        return res;
    }

    private int help(int i) {
        lines.clear();
        horizontalLines = 1;

        int count = 1;
        int duplicates = 0;
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = addLine(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    public Pair<Integer, Integer> addLine(int i, int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        if ((x1 == x2) && (y1 == y2)) {
            // 两个点重复时，该点的任意一条直线上的点都应该+1。因此用一个变量dup来保存于当前点重复的点
            duplicates++;
        } else if (y1 == y2) {
            // 平行于x轴
            horizontalLines += 1;
            count = Math.max(horizontalLines, count);
        } else {
            Pair<Integer, Integer> slope = getSlope(x1, y1, x2, y2);
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return Pair.of(count, duplicates);
    }

    /**
     * 使用分数 保存斜率
     * <p>
     * y = kx + b
     * y1 = kx1 + b y2 = kx2 + b
     * y1 - y2 = kx1 - kx2
     * k = (y1 - y2) / (x1 - x2)
     * 分数存储 y1 - y2 和 x1 - x2
     */
    private Pair<Integer, Integer> getSlope(int x1, int y1, int x2, int y2) {
        int deltaX = x1 - x2, deltaY = y1 - y2;
        if (deltaX == 0) {
            return Pair.of(0, 0);
        } else if (deltaY == 0) {
            return Pair.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else if (deltaX < 0) {
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        Integer gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();
        return Pair.of(deltaX / gcd, deltaY / gcd);
    }
}
