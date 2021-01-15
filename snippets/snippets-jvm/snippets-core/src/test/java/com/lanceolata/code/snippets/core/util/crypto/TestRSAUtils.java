package com.lanceolata.code.snippets.core.util.crypto;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class TestRSAUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestAESUtils.class);

    private static KeyPair keyPair = null;

    private static String content = "com.lanceolata.common.util.TestRSAUtils";

    @BeforeClass
    public static void init() {
        try {
            keyPair = RSAUtils.initKey();
        } catch (Exception e) {
            LOGGER.error("TestRSAUtils init exception:", e);
        }
    }

    @Test
    public void testEncryptAndDecrypt1() throws Exception {
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        byte[] publicKeyEncoded = publicKey.getEncoded();

        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] privateKeyEncoded = privateKey.getEncoded();

        byte[] encrypt = null, decrypt = null;

        // 公钥加密 私钥解密
        encrypt = RSAUtils.encryptByPublicKey(content.getBytes(), publicKeyEncoded);
        decrypt = RSAUtils.decryptByPrivateKey(encrypt, privateKeyEncoded);
        Assert.assertArrayEquals(content.getBytes(), decrypt);

        encrypt = RSAUtils.encrypt(content.getBytes(), publicKey);
        decrypt = RSAUtils.decrypt(encrypt, privateKey);
        Assert.assertArrayEquals(content.getBytes(), decrypt);
    }

    @Test
    public void testEncryptAndDecrypt2() throws Exception {
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        byte[] publicKeyEncoded = publicKey.getEncoded();

        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] privateKeyEncoded = privateKey.getEncoded();

        byte[] encrypt = null, decrypt = null;

        // 私钥加密 公钥解密
        encrypt = RSAUtils.encryptByPrivateKey(content.getBytes(), privateKeyEncoded);
        decrypt = RSAUtils.decryptByPublicKey(encrypt, publicKeyEncoded);
        Assert.assertArrayEquals(content.getBytes(), decrypt);

        encrypt = RSAUtils.encrypt(content.getBytes(), privateKey);
        decrypt = RSAUtils.decrypt(encrypt, publicKey);
        Assert.assertArrayEquals(content.getBytes(), decrypt);
    }
}
