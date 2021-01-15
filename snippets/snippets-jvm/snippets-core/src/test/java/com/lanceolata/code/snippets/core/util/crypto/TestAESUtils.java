package com.lanceolata.code.snippets.core.util.crypto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;

public class TestAESUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAESUtils.class);

    private static SecretKey secretKey = null;
    private static byte[] keyByteArray = null;

    private static String content = "com.lanceolata.code.snippets.commom.java.util.crypto.TestAESUtils";

    @BeforeClass
    public static void init() {
        try {
            secretKey = AESUtils.init();
            keyByteArray = secretKey.getEncoded();
        } catch (Exception e) {
            LOGGER.error("AES init exception:", e);
        }
    }

    @Test
    public void testEncryptAndDecryptByKey() throws Exception {
        byte[] encrypt = AESUtils.encrypt(content.getBytes(), secretKey);
        byte[] decrypt = AESUtils.decrypt(encrypt, secretKey);
        Assert.assertNotNull(encrypt);
        Assert.assertArrayEquals(content.getBytes(), decrypt);
    }

    @Test
    public void testEncryptAndDecryptByBytes() throws Exception {
        byte[] encrypt = AESUtils.encrypt(content.getBytes(), keyByteArray);
        byte[] decrypt = AESUtils.decrypt(encrypt, keyByteArray);
        Assert.assertNotNull(encrypt);
        Assert.assertArrayEquals(content.getBytes(), decrypt);
    }
}
