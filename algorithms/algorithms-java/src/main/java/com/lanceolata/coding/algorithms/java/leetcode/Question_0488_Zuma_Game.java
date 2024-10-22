package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_0488_Zuma_Game {
    private class ZumaState {
        private long board;
        private long hand;

        public ZumaState(long board, long hand) {
            this.board = board;
            this.hand = hand;
        }
    }

    public int findMinStep(String board, String hand) {
        // Init root state
        ZumaState root = new ZumaState(encode(board), encode(hand));

        // Create the initial set containing the root state
        ArrayList<ZumaState> curr = new ArrayList<>();
        curr.add(root);

        HashSet<Long> visited = new HashSet<>();
        visited.add(root.board);

        return bfs(curr, visited, 1);
    }

    private int bfs(List<ZumaState> curr, Set<Long> visited, int step) {
        if (curr.isEmpty()) return -1;

        ArrayList<ZumaState> next = new ArrayList<>();
        long[] boardList = new long[32];

        for (ZumaState state : curr) {
            ArrayList<long[]> handList = generateHandList(state.hand);
            int size = generateBoardList(boardList, state.board);

            for (long[] p : handList) {
                final long ball = p[0];
                final long newHand = p[1];

                for (int i = 0; i < size; ++i) {
                    final long L = (boardList[i] >> ((i + 1) * 3)) & 0b111;
                    final long R = (boardList[i] >> ((i - 1) * 3)) & 0b111;

                    // Pruning check
                    if (((step > 1) || (L != R)) && ball != L) {
                        continue;
                    }
                    final long rawBoard = boardList[i] | (ball << (i * 3));
                    final long newBoard = updateBoard(rawBoard, i, i);

                    // Terminal check: Find solution
                    if (newBoard == 0) {
                        return step;
                    }

                    if (newHand > 0 && !visited.contains(newBoard)) {
                        next.add(new ZumaState(newBoard, newHand));
                        visited.add(newBoard);
                    }
                }
            }
        }
        return bfs(next, new HashSet<>(), step + 1);
    }


    private long updateBoard(long board, int hi, int lo) {
        // Trerminal check: empty or diff-chars
        if (lo < 0 || fetch(board, hi) != fetch(board, lo)) {
            return removeRange(board, hi, lo);
        }
        // Settings for checking current pass
        final long currBall = fetch(board, hi);
        int count = (lo == hi) ? 1 : 2;

        // Update hi pointer
        while (fetch(board, hi + 1) == currBall) {
            hi++;
            count++;
        }
        // Update lo pointer
        while (fetch(board, lo - 1) == currBall) {
            lo--;
            count++;
        }

        // Terminal check: double-chars
        if (count < 3) {
            return removeRange(board, hi, lo);
        }
        return updateBoard(board, hi + 1, lo - 1);
    }


    /**
     * Returns the "ball" at index-th "position"
     */
    private long fetch(long state, int index) {
        return (state >> (index * 3)) & 0b111;
    }


    private int generateBoardList(long[] list, long board) {
        int k = 0;
        while (true) {
            list[k] = insertHelper(board, k);
            if ((board >> (k * 3) & 0b111) == 0)
                break;
            k++;
        }
        return k;
    }


    private ArrayList<long[]> generateHandList(long hand) {
        final ArrayList<long[]> handList = new ArrayList<>();
        long lastBall = 0L;

        for (int i = 0; true; ++i) {
            final long pickBall = (hand >> (i * 3)) & 0b111;
            if (pickBall == 0)
                break;

            if (pickBall != lastBall) {
                final long nextHand = removeHelper(hand, i);
                handList.add(new long[]{pickBall, nextHand});
            }
            lastBall = pickBall;
        }
        return handList;
    }


    private long encode(String state) {
        long result = 0L;
        for (char c : state.toCharArray()) {
            result = (result << 3) | encodeToBin(c);
        }
        return result;
    }


    /**
     * Return a 64-bit with n 1's on the least significant side.
     */
    private long trailingOnesMask(int n) {
        if (n < 1) {
            return 0L;
        }
        return (-1L) >>> (64 - n);
    }


    /**
     * Remove everything inbetween [hi] and [lo], exclusive
     */
    private long removeRange(long state, int hi, int lo) {
        if (hi - lo <= 1) return state;
        lo++;
        final int rsh = (hi - lo) * 3;
        final long mask = trailingOnesMask(lo * 3);
        return ((state >> rsh) & ~mask) | (state & mask);
    }


    private long removeHelper(long state, int offset) {
        final long mask = trailingOnesMask(offset * 3);
        return ((state >> 3) & ~mask) | (state & mask);
    }


    private long insertHelper(long state, int offset) {
        final long mask = trailingOnesMask(offset * 3);
        return ((state & ~mask) << 3) | (state & mask);
    }

    private int encodeToBin(char c) {
        switch (c) {
            case '_':
                return 0;
            case 'B':
                return 1;
            case 'G':
                return 2;
            case 'R':
                return 3;
            case 'W':
                return 4;
            case 'Y':
                return 5;
            default:
                throw new IllegalArgumentException("Invalid color code: " + c);
        }
    }
}
