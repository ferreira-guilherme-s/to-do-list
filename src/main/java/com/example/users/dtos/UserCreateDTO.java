package com.example.users.dtos;

import com.example.users.utils.GenerateHash;
import com.example.users.utils.RandomStringGenerator;
import jakarta.validation.constraints.NotBlank;

public class UserCreateDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    private String email;

    private String password;

    public UserCreateDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isBlank()) {
            password = RandomStringGenerator.generateRandomString(16);
        }
        try {
            this.password = GenerateHash.generateHash(password);
        } catch (Exception e) {
            this.password = "password";
        }
    }
}
