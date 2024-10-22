package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Question_0535_Encode_and_Decode_TinyURL {

    private static Map<String, String> codeToUrl = new HashMap<>(), urlToCode = new HashMap<>();
    private static String chars = "0987654321abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!urlToCode.containsKey(longUrl)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                char c = chars.charAt(rand.nextInt(chars.length()));
                sb.append(c);
                if (!codeToUrl.containsKey(sb.toString())) {
                    codeToUrl.put(sb.toString(), longUrl);
                    urlToCode.put(longUrl, sb.toString());
                    return "http://tinyurl.com/" + sb.toString();
                }
            }
        }
        return "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrl.get(shortUrl.substring(19));
    }
}
