package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0649_Dota2_Senate {
    public String predictPartyVictory(String senate) {
        // R = true表示本轮循环结束后，字符串里依然有R。D同理
        boolean R = true;
        boolean D = true;
        // 当flag大于0时，R在D前出现，R可以消灭D。当flag小于0时，D在R前出现，D可以消灭R
        int flag = 0;
        char[] senateArray = senate.toCharArray();
        while (R && D) { // 一旦R或者D为false，就结束循环，说明本轮结束后只剩下R或者D了
            R = false;
            D = false;
            for (int i = 0; i < senateArray.length; i++) {
                if (senateArray[i] == 'R') {
                    if (flag < 0) {
                        senateArray[i] = '0'; // 消灭R，R此时为false
                    } else {
                        R = true; // 如果没被消灭，本轮循环结束有R
                    }
                    flag += 1;
                }

                if (senateArray[i] == 'D') {
                    if (flag > 0) {
                        senateArray[i] = '0';
                    } else {
                        D = true;
                    }
                    flag -= 1;
                }
            }
        }

        // 循环结束之后，R和D只能有一个为true
        return R == true ? "Radiant" : "Dire";
    }
}
