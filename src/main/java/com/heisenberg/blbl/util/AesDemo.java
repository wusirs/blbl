package com.heisenberg.blbl.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

public class AesDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AesDemo.class);

    public static void main(String[] args) throws Exception {
        jjmTest();
    }

    public static void jjmTest() throws Exception {
        String secretKey = CryptoUtils.generateSymmetricKey(CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5);
        String cipherText = CryptoUtils.encryptSymmetrically(secretKey, null, "test", CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5);
        LOGGER.info("生成的密钥为：{}", secretKey);
        LOGGER.info("加密后的密文为：{}", cipherText);
        LOGGER.info("解密后的明文为：{}", CryptoUtils.decryptSymmetrically(secretKey, null, cipherText, CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5));
    }


    public static void decrypt() throws Exception {
        String secretKey = "sQPoC/1do9BZMkg8I5c09A==";
        String cipherText = "iTgNXRqU80YZ52+iV7Ew2w==";
        LOGGER.info("解密后的明文为：{}", CryptoUtils.decryptSymmetrically(secretKey, null, cipherText, CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5));
    }
}

