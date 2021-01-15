package com.lanceolata.code.snippets.core.util;

import java.util.Base64;

/**
 * Base64工具类
 */
public final class Base64Utils {
    private Base64Utils() {}

    /**
     * 编码
     *
     * @param data
     * @return
     */
    public static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * 编码Mime
     *
     * @param data
     * @return
     */
    public static String encodeMime(byte[] data) {
        return Base64.getMimeEncoder().encodeToString(data);
    }

    /**
     * 编码Url
     *
     * @param data
     * @return
     */
    public static String encodeUrl(byte[] data) {
        return Base64.getUrlEncoder().encodeToString(data);
    }

    /**
     * 解码
     *
     * @param str
     * @return
     */
    public static byte[] decode(String str) {
        return Base64.getDecoder().decode(str);
    }

    /**
     * 解码Mime
     *
     * @param str
     * @return
     */
    public static byte[] decodeMime(String str) {
        return Base64.getMimeDecoder().decode(str);
    }

    /**
     * 解码Url
     *
     * @param str
     * @return
     */
    public static byte[] decodeUrl(String str) {
        return Base64.getUrlDecoder().decode(str);
    }
}
