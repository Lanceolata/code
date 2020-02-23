package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question_0468_Validate_IP_Address {
    public String validIPAddress(String IP) {
        Pattern p1 = Pattern.compile("((([1-9]?|1\\d|2[0-4])\\d|25[0-5])\\.){3}(([1-9]?|1\\d|2[0-4])\\d|25[0-5])");
        Pattern p2 = Pattern.compile("(?i)([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}");

        Matcher m1 = p1.matcher(IP);
        if (m1.matches()) return "IPv4";

        Matcher m2 = p2.matcher(IP);
        if (m2.matches()) return "IPv6";

        return "Neither";
    }
}
