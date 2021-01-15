package com.lanceolata.code.snippets.core.util.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * AES加密工具类
 *
 * 高级加密标准（英语：Advanced Encryption Standard，缩写：AES），是一种区块加密标准。
 */
public final class AESUtils {
    private AESUtils() {}

    private static final String ALGORITHM_PADDING = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHM_NAME = "AES";

    /**
     * 生成密钥
     *
     * @return
     * @throws Exception
     */
    public static SecretKey init() throws Exception {
        KeyGenerator sKeyGen = KeyGenerator.getInstance(ALGORITHM_NAME);
        sKeyGen.init(128);
        return sKeyGen.generateKey();
    }

    /**
     * 生成密钥
     *
     * @return
     * @throws Exception
     */
    public static SecretKey init(byte[] seed) throws Exception {
        KeyGenerator sKeyGen = KeyGenerator.getInstance(ALGORITHM_NAME);
        sKeyGen.init(128, new SecureRandom(seed));
        return sKeyGen.generateKey();
    }

    /**
     * 加密
     *
     * @param content       数据
     * @param key           加密密钥
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM_NAME);
        return encrypt(content, secretKey);
    }

    /**
     * 加密
     *
     * @param content       数据
     * @param key           加密密钥
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(content);
    }

    /**
     * 解密
     *
     * @param content       数据
     * @param key           解密密钥
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM_NAME);
        return decrypt(content, secretKey);
    }

    /**
     * 解密
     *
     * @param content       数据
     * @param key           解密密钥
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(content);
    }
}
