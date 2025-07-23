package com.BlogSphere.Spring_boot_project.utils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtils {
    private static final String SECRET_KEY = "aesEncryptionKey";  // Must be 16 bytes

    public static String encrypt(String input) throws Exception {
        if (input == null) throw new IllegalArgumentException("Input can't be null");

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
    }

    public static String decrypt(String encrypted) throws Exception {
        if (encrypted == null) throw new IllegalArgumentException("Input can't be null");

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
    }
    }

