package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, preBuy = 0, preSell = 0;
        for (int p : prices) {
            preBuy = buy;
            buy = Math.max(preSell - p, buy);
            preSell = sell;
            sell = Math.max(preBuy + p, sell);
        }
        return sell;
    }
}
