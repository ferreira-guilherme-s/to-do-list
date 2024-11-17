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

    private String document;

    public UserCreateDTO(String name, String email, String password, String document) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
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
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
