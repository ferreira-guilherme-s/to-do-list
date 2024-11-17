package com.example.users.utils;

public class PasswordGenerate {
    public static String generatePassword(String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) {
            rawPassword = RandomStringGenerator.generateRandomString(16);
        }

        try {
            return GenerateHash.generateHash(rawPassword);
        } catch (Exception e) {
            throw new RuntimeException("Failed to hash password", e);
        }
    }
}
