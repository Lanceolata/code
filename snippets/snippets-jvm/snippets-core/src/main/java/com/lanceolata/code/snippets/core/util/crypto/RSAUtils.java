package com.lanceolata.code.snippets.core.util.crypto;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加密工具类
 */
public final class RSAUtils {
    private RSAUtils() {}

    /**
     * 加密填充方式
     */
    private static final String ALGORITHM_PADDING = "RSA/ECB/PKCS1Padding";
    private static final String ALGORITHM_NAME = "RSA";
    private static final String BOUNCY_CASTLE_PROVIDER = "BC";

    /**
     * 秘钥默认长度
     */
    private static final int DEFAULT_KEY_SIZE = 1024;

    static{
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 生成密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair initKey() throws NoSuchAlgorithmException {
        return initKey(DEFAULT_KEY_SIZE);
    }

    /**
     * 生成密钥
     *
     * @param keySize
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair initKey(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM_NAME);
        keyPairGen.initialize(keySize);
        return keyPairGen.generateKeyPair();
    }

    public static PublicKey bytes2PublicKey(byte[] key)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME, BOUNCY_CASTLE_PROVIDER);
        return keyFactory.generatePublic(x509KeySpec);
    }

    public static PrivateKey bytes2PrivateKey(byte[] key)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME, BOUNCY_CASTLE_PROVIDER);
        return keyFactory.generatePrivate(pkcs8KeySpec);
    }

    /**
     * 公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws ShortBufferException
     * @throws NoSuchPaddingException
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, ShortBufferException, NoSuchPaddingException {
        PublicKey publicKey = bytes2PublicKey(key);
        return encrypt(data, publicKey);
    }

    /**
     * 私钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws ShortBufferException
     * @throws NoSuchPaddingException
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, ShortBufferException, NoSuchPaddingException {
        PrivateKey privateKey = bytes2PrivateKey(key);
        return encrypt(data, privateKey);
    }

    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws ShortBufferException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encrypt(byte[] data, Key key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException,
            BadPaddingException, ShortBufferException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(ALGORITHM_PADDING, BOUNCY_CASTLE_PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        int blockSize = cipher.getBlockSize();
        if (blockSize>0) {
            int outputSize = cipher.getOutputSize(data.length);
            int leavedSize = data.length % blockSize;
            int blocksSize = leavedSize != 0 ? data.length / blockSize + 1
                    : data.length / blockSize;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0, remainSize = 0;
            while ((remainSize = data.length - i * blockSize) > 0) {
                int inputLen = remainSize > blockSize?blockSize:remainSize;
                cipher.doFinal(data, i * blockSize, inputLen, raw, i * outputSize);
                i++;
            }
            return raw;
        }

        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchPaddingException
     * @throws IOException
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, NoSuchPaddingException, IOException {
        PublicKey publicKey = bytes2PublicKey(key);
        return decrypt(data, publicKey);
    }

    /**
     * 私钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchPaddingException
     * @throws IOException
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, NoSuchPaddingException, IOException {
        PrivateKey privateKey = bytes2PrivateKey(key);
        return decrypt(data, privateKey);
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public static byte[] decrypt(byte[] data, Key key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IOException {
        // 对数据解密
        Cipher cipher = Cipher.getInstance(ALGORITHM_PADDING, BOUNCY_CASTLE_PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, key);

        int blockSize = cipher.getBlockSize();
        if(blockSize>0){
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;
            while (data.length - j * blockSize > 0) {
                bout.write(cipher.doFinal(data, j * blockSize, blockSize));
                j++;
            }
            return bout.toByteArray();
        }

        return cipher.doFinal(data);
    }
}
