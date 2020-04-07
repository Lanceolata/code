package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0464_Can_I_Win {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, map);
    }

    public boolean canWin(int length, int total, int used, Map<Integer, Boolean> m) {
        if (m.containsKey(used)) {
            return m.get(used);
        }
        for (int i = 0; i < length; ++i) {
            int cur = (1 << i);
            if ((cur & used) == 0) {
                if (total <= i + 1 || !canWin(length, total - (i + 1), cur | used, m)) {
                    m.put(used, true);
                    return true;
                }
            }
        }
        m.put(used, false);
        return false;
    }
}
