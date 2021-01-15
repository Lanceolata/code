package com.lanceolata.code.snippets.core.util.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * HmacSha1加密工具类
 */
public final class HmacSha1Utils {
    private HmacSha1Utils() {}

    private static final String ALGORITHM_NAME = "HmacSHA1";

    /**
     * 加密
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        SecretKeySpec signingKey = new SecretKeySpec(key, ALGORITHM_NAME);
        return encrypt(content, signingKey);
    }

    /**
     * 加密
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, Key key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(ALGORITHM_NAME);
        mac.init(key);
        return mac.doFinal(content);
    }
}
