package com.example.users.services;

import com.example.users.dtos.UserCreateDTO;
import com.example.users.dtos.UserLoginDTO;
import com.example.users.entities.UsersEntity;
import com.example.users.exceptions.InvalidCredentialsException;
import com.example.users.interfaces.IUser;
import com.example.users.repositories.UserRepository;
import com.example.users.utils.GenerateHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService implements IUser {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(UserCreateDTO user) {

    }

    @Override
    public Optional<UsersEntity> login(UserLoginDTO body) {
        Optional<UsersEntity> userOpt = userRepository.login(body.getEmail(), body.getPassword());

        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        UsersEntity user = userOpt.get();
        try {
            String hashedPassword = GenerateHash.generateHash(body.getPassword());
            if (!hashedPassword.equals(user.getPassword())) {
                throw new InvalidCredentialsException("Invalid email or password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash for password", e);
        }

        return Optional.of(user);
    }

    @Override
    public void updateUser(UserCreateDTO user) {

    }
}
