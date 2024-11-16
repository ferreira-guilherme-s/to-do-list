package com.example.users.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateHash {
    public static String generateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hash = digest.digest(password.getBytes());

        StringBuilder hexString= new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x",  0xFF & b));
        }

        return hexString.toString();
    }
}
