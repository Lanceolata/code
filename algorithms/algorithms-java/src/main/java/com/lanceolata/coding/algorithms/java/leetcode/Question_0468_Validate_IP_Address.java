package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0468_Validate_IP_Address {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            String[] ipv4 = queryIP.split("\\.", -1);
            for (String s : ipv4) {
                if (!isIPv4(s)) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            String[] ipv6 = queryIP.split("\\:", -1);
            for (String s : ipv6) {
                if (!isIPv6(s)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static boolean isIPv4(String s) {
        try {
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIPv6(String s) {
        if (s.length() > 4) {
            return false;
        }
        try {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
