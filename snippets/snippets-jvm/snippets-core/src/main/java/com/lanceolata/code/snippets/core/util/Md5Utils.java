package com.lanceolata.code.snippets.core.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Md5工具类
 */
public final class Md5Utils {
    private Md5Utils() {}

    /**
     * MD5值 32位小写的字符串
     *
     * @param s
     * @return
     */
    public static String md5Hex(String s) {
        return DigestUtils.md5Hex(s);
    }
}
