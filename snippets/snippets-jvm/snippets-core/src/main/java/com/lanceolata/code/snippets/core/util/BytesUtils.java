package com.lanceolata.code.snippets.core.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Bytes工具类
 */
public final class BytesUtils {
    private BytesUtils() {}

    /**
     * byte数组 --> 16进制字符串
     *
     * @param data
     * @return
     */
    public static String encodeHexString(byte[] data) {
        return Hex.encodeHexString(data);
    }

    /**
     * 16进制字符串 --> byte数组
     *
     * @param data
     * @return
     */
    public static byte[] hexString2Bytes(String data) throws DecoderException {
        return Hex.decodeHex(data);
    }
}
