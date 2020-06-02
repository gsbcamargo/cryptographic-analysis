package com.pucpr.criptografia;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AES16bytes {

    static String IV = "BBBBBBBBBBBBBBBB";
    static String originalText= "RSA é um algoritmo que deve o seu nome a três professores do MIT: Ronald Rivest, Adi Shamir e Leonard Adleman";
    static String encryptionKey = "0123456789ABCDEF";


    public static void main(String[] args) {

        try {
            long initialTime = System.currentTimeMillis();
            System.out.println("Original text: " + originalText);

            byte[] encryptedText;

            encryptedText = encrypt(originalText, encryptionKey);

            System.out.println("Encrypted text");
            for (byte b : encryptedText) System.out.println((int) b + " ");

            long finalTime = System.currentTimeMillis();

            System.out.println();

            String decryptedText = decrypt(encryptedText, encryptionKey);

            System.out.println("Decrypted text: " + decryptedText);

            System.out.println("Execution time: " + (finalTime - initialTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] encrypt(String originalText, String encryptionKey) throws Exception {
        Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        encrypt.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
        return encrypt.doFinal(originalText.getBytes(StandardCharsets.UTF_8));
    }

    private static String decrypt(byte[] encryptedText, String encryptionKey) throws Exception {
        Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        decrypt.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
        return new String(decrypt.doFinal(encryptedText), StandardCharsets.UTF_8);
    }
}