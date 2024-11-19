package com.example.users.services;

import com.example.users.dtos.UserCreateDTO;
import com.example.users.dtos.UserLoginDTO;
import com.example.users.entities.UsersEntity;
import com.example.users.exceptions.InvalidCredentialsException;
import com.example.users.interfaces.IUser;
import com.example.users.repositories.UserRepository;
import com.example.users.utils.GenerateHash;
import com.example.users.utils.PasswordGenerate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUser {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void insertUser(UserCreateDTO user) {
        try {
            user.setPassword(PasswordGenerate.generatePassword(user.getPassword()));

            UsersEntity userEntity = modelMapper.map(user, UsersEntity.class);

            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UsersEntity> login(UserLoginDTO body) {
        Optional<UsersEntity> userOpt = userRepository.findByEmail(body.getEmail());

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

    @Override
    public Optional<UsersEntity> getUserById(UUID id) {
        Optional<UsersEntity> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(userOpt.get());
    }
}
