package com.pucpr.criptografia;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class RSA1024Private {

    public static final String ALGORITHM = "RSA";

    // private key location in OS
    public static final String PATH_PRIVATE_KEY = "C:/Users/HP/keys/KeyGen/private1024-p.key";

    // public key location in OS
    public static final String PATH_PUBLIC_KEY = "C:/Users/HP/keys/KeyGen/public1024-p.key";

    // 1024 bytes keygen
    // stores the key set into private.key and public.key files

    public static void generateKey() {

        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(1024);
            final KeyPair key = keyGen.generateKeyPair();

            File privateKeyFile = new File(PATH_PRIVATE_KEY);
            File publicKeyFile = new File(PATH_PUBLIC_KEY);

            // creating files to store private and public key values
            if (privateKeyFile.getParentFile() != null) {
                privateKeyFile.getParentFile().mkdirs();
            }

            privateKeyFile.createNewFile();

            if (publicKeyFile.getParentFile() != null) {
                privateKeyFile.getParentFile().mkdirs();
            }

            publicKeyFile.createNewFile();

            // stores public key into the file
            ObjectOutputStream publicKeyOS = new ObjectOutputStream(
                    new FileOutputStream(publicKeyFile));
            publicKeyOS.writeObject(key.getPublic());
            publicKeyOS.close();

            // stores private key into the file
            ObjectOutputStream privateKeyOS = new ObjectOutputStream(
                    new FileOutputStream(privateKeyFile));
            privateKeyOS.writeObject(key.getPrivate());
            privateKeyOS.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // verifies if the key pair was already generated

    public static boolean verifyIfThereAreKeys() {

        File privateKey = new File(PATH_PRIVATE_KEY);
        File publicKey = new File(PATH_PUBLIC_KEY);

        return privateKey.exists() && publicKey.exists();
    }

    // encrypts original text using private key

    public static byte[] encrypts(String text, PrivateKey key) {
        byte[] cipherText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cipherText;
    }

    // decrypts original text using public key

    public static String decrypts(byte[] text, PublicKey key) {
        byte[] decryptedText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decryptedText = cipher.doFinal(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assert decryptedText != null;
        return new String(decryptedText);
    }

    public static void main(String[] args) {

        try {

            long initialTime = System.currentTimeMillis();

            if (!verifyIfThereAreKeys()) {
                generateKey();
            }

            final String originalText = "RSA é um algoritmo que deve o seu nome a três professores do MIT: Ronald Rivest, Adi Shamir e Leonard Adleman";

            ObjectInputStream inputStream = null;

            // encrypts using private key
            inputStream = new ObjectInputStream(new FileInputStream(PATH_PRIVATE_KEY));
            final PrivateKey privateKey = (PrivateKey) inputStream.readObject();
            final byte[] encryptedText = encrypts(originalText, privateKey);
            inputStream.close();

            // decrypts using public key
            inputStream = new ObjectInputStream(new FileInputStream(PATH_PUBLIC_KEY));
            final PublicKey publicKey = (PublicKey) inputStream.readObject();
            final String decryptedText = decrypts(encryptedText, publicKey);
            inputStream.close();

            long finalTime = System.currentTimeMillis();

            System.out.println("Key size: 1024 bits.");
            System.out.println("Original text: " + originalText);
            System.out.println("Encrypted text: " + Arrays.toString(encryptedText));
            System.out.println("Decrypted text: " + decryptedText);

            System.out.println("Execution time: " + (finalTime - initialTime + " milliseconds."));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}