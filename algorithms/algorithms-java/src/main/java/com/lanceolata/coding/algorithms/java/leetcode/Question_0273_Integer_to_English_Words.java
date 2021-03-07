package com.lanceolata.coding.algorithms.java.leetcode;

class Question_0273_Integer_to_English_Words {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return help(num);
    }

    private String help(int num) {
        String result = null;
        if (num < 10) {
            result = belowTen[num];
        } else if (num < 20) {
            result = belowTwenty[num - 10];
        } else if (num < 100) {
            result = belowHundred[num / 10] + " " + help(num % 10);
        } else if (num < 1000) {
            result = help(num/100) + " Hundred " +  help(num % 100);
        } else if (num < 1000000) {
            result = help(num/1000) + " Thousand " +  help(num % 1000);
        } else if (num < 1000000000) {
            result = help(num/1000000) + " Million " +  help(num % 1000000);
        } else {
            result = help(num/1000000000) + " Billion " + help(num % 1000000000);
        }
        return result.trim();
    }
}