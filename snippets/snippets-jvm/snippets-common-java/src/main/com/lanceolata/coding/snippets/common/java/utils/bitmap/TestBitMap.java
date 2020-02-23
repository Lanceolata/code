package com.lanceolata.coding.snippets.common.java.utils.bitmap;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import org.roaringbitmap.RoaringBitmap;

import java.io.*;
import java.util.*;

public class TestBitMap {
    private int START = 10000;
    private int END = 90000;

    private int num;
    private int size;

    public static void main(String[] args) throws IOException {
        int end = 2000000;
        int num = 50000;
        int[] array = new int[num];
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            array[i] = r.nextInt(end);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        System.out.println(set.size() * 8);

        // bitmap
        BitSet bitset = new BitSet();
        for (int i = 0; i < array.length; i++) {
            bitset.set(array[i]);
        }
        System.out.println(BitSetUtils.serialize(bitset).length);

        // EWAH
        EWAHCompressedBitmap bitmap = new EWAHCompressedBitmap();
        for (int i = 0; i < array.length; i++) {
            bitmap.set(array[i]);
        }
        System.out.println(EWAHCompressedBitmapUtils.serialize(bitmap).length);

        // roaring
        RoaringBitmap rbitmap = new RoaringBitmap();
        for (int i = 0; i < array.length; i++) {
            rbitmap.add(array[i]);
        }
        System.out.println(RoaringBitmapUtils.serialize(rbitmap).length);
    }

//    public static void main(String[] args) throws IOException {
//        TestBitMap test = new TestBitMap(20000, 1000);
//        test.test();
//    }

    public TestBitMap(int num, int size) {
        this.num = num;
        this.size = size;
    }

    public void test() {
        int[][] arrs = init();
        List<Set<Integer>> sets = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j : arrs[i]) {
                set.add(j);
            }
            sets.add(set);
        }
        testString(arrs, sets);
        testBitSet(arrs, sets);
        testEWAH(arrs, sets);
        testRoaring(arrs, sets);
    }

    private int[][] init() {
        int[][] arrs = new int[num][size];
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < size; j++) {
                arrs[i][j] = r.nextInt(END) + START;
            }
        }
        return arrs;
    }

    private void testString(int[][] arrs, List<Set<Integer>> sets) {
        System.out.println("------------------------");
        System.out.println("testString");
        List<InnerByteArray> bytes = testStringStorage(arrs);
        System.out.println(countBytes(bytes));
        Long start = System.currentTimeMillis();
        List<Set<Integer>> setList = testStringSet(bytes);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sets.equals(setList));
    }

    private void testBitSet(int[][] arrs, List<Set<Integer>> sets) {
        System.out.println("------------------------");
        System.out.println("testBitSet");
        List<InnerByteArray> bytes = testBitSetStorage(arrs);
        System.out.println(countBytes(bytes));
        Long start = System.currentTimeMillis();
        List<Set<Integer>> setList = testBitSetSet(bytes);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sets.equals(setList));
    }

    private void testEWAH(int[][] arrs, List<Set<Integer>> sets) {
        System.out.println("------------------------");
        System.out.println("testEWAH");
        try {
            List<InnerByteArray> bytes = testEWAHStorage(arrs);
            System.out.println(countBytes(bytes));
            Long start = System.currentTimeMillis();
            List<Set<Integer>> setList = testEWAHSet(bytes);
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(sets.equals(setList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testRoaring(int[][] arrs, List<Set<Integer>> sets) {
        System.out.println("------------------------");
        System.out.println("testRoaring");
        try {
            List<InnerByteArray> bytes = testRoaringStorage(arrs);
            System.out.println(countBytes(bytes));
            Long start = System.currentTimeMillis();
            List<Set<Integer>> setList = testRoaringSet(bytes);
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(sets.equals(setList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<InnerByteArray> testStringStorage(int[][] arrs) {
        List<InnerByteArray> res = new ArrayList<>();
        for (int i = 0; i < arrs.length; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < arrs[i].length; j++) {
                set.add(arrs[i][j] + "");
            }
            String str = String.join(",", set);
            res.add(new InnerByteArray(str.getBytes()));
        }
        return res;
    }

    private List<Set<Integer>> testStringSet(List<InnerByteArray> in) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            Set<Integer> set = new HashSet<>();
            byte[] bytes = in.get(i).bytes;
            String str = new String(bytes);
            String[] arr = str.split(",");
            for (int j = 0; j < arr.length; j++) {
                set.add(Integer.parseInt(arr[j]));
            }
            sets.add(set);
        }
        return sets;
    }

    private List<InnerByteArray> testBitSetStorage(int[][] arrs) {
        List<InnerByteArray> res = new ArrayList<>();
        for (int i = 0; i < arrs.length; i++) {
            BitSet bitset = new BitSet();
            for (int j = 0; j < arrs[i].length; j++) {
                bitset.set(arrs[i][j]);
            }
            res.add(new InnerByteArray(BitSetUtils.serialize(bitset)));
        }
        return res;
    }

    private List<Set<Integer>> testBitSetSet(List<InnerByteArray> in) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            byte[] bytes = in.get(i).bytes;
            BitSet bitset = BitSetUtils.deserialize(bytes);
            sets.add(BitSetUtils.toSet(bitset));
        }
        return sets;
    }

    private List<InnerByteArray> testEWAHStorage(int[][] arrs) throws Exception {
        List<InnerByteArray> res = new ArrayList<>();
        for (int i = 0; i < arrs.length; i++) {
            EWAHCompressedBitmap bitmap = new EWAHCompressedBitmap();
            for (int j = 0; j < arrs[i].length; j++) {
                bitmap.set(arrs[i][j]);
            }
            res.add(new InnerByteArray(EWAHCompressedBitmapUtils.serialize(bitmap)));
        }
        return res;
    }

    private List<Set<Integer>> testEWAHSet(List<InnerByteArray> in) throws Exception {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            byte[] bytes = in.get(i).bytes;
            EWAHCompressedBitmap bitmap = EWAHCompressedBitmapUtils.deserialize(bytes);
            sets.add(EWAHCompressedBitmapUtils.toSet(bitmap));
        }
        return sets;
    }

    private List<InnerByteArray> testRoaringStorage(int[][] arrs) throws Exception {
        List<InnerByteArray> res = new ArrayList<>();
        for (int i = 0; i < arrs.length; i++) {
            RoaringBitmap bitmap = new RoaringBitmap();
            for (int j = 0; j < arrs[i].length; j++) {
                bitmap.add(arrs[i][j]);
            }
            res.add(new InnerByteArray(RoaringBitmapUtils.serialize(bitmap)));
        }
        return res;
    }

    private List<Set<Integer>> testRoaringSet(List<InnerByteArray> in) throws Exception {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            byte[] bytes = in.get(i).bytes;
            RoaringBitmap bitmap = RoaringBitmapUtils.deserialize(bytes);
            sets.add(RoaringBitmapUtils.toSet(bitmap));
        }
        return sets;
    }

    static class InnerByteArray {
        private byte[] bytes;
        public InnerByteArray(byte[] bytes) {
            this.bytes = bytes;
        }
    }

    private long countBytes(List<InnerByteArray> lists) {
        long count = 0;
        for (InnerByteArray arr : lists) {
            count += arr.bytes.length;
        }
        return count;
    }

    private boolean equals(List<Set<Integer>> sets1, List<Set<Integer>> sets2) {
        if (sets1.size() != sets2.size()) {
            return false;
        }
        for (int i = 0; i < sets1.size(); i++) {
            if (!sets1.get(i).equals(sets2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
