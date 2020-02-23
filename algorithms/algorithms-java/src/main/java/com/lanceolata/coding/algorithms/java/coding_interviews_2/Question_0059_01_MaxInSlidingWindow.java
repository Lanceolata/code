package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Question_0059_01_MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (i >= size && num[i - size] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < num[i]) {
                deque.pollLast();
            }
            deque.addLast(num[i]);
            if (i >= size - 1) {
                res.add(deque.peekFirst());
            }
        }
        return res;
    }

    public ArrayList<Integer> maxInWindowsIndex(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (i >= size && i - size == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= size - 1) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
