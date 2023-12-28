package com.heisenberg.blbl.util;

import java.security.NoSuchAlgorithmException;

public class AesDemo {

    public static void main(String[] args) throws Exception {
        jjmTest();
    }

    public static void jjmTest() throws Exception {
        String secretKey = CryptoUtils.generateSymmetricKey(CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5);
        String cipherText = CryptoUtils.encryptSymmetrically(secretKey, null, "test", CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5);
        System.out.println("生成的密钥为：" + secretKey);
        System.out.println("加密后的密文为：" + cipherText);
        System.out.println("解密后的明文为：" + CryptoUtils.decryptSymmetrically(secretKey, null, cipherText, CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5));
    }


    public static void decrypt() throws Exception {
        String secretKey = "sQPoC/1do9BZMkg8I5c09A==";
        String cipherText = "iTgNXRqU80YZ52+iV7Ew2w==";
        System.out.println("解密后的明文为：" + CryptoUtils.decryptSymmetrically(secretKey, null, cipherText, CryptoUtils.Algorithm.Encryption.AES_ECB_PKCS5));
    }
}

