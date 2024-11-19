package com.example.users.interfaces;

import com.example.users.dtos.UserCreateDTO;
import com.example.users.dtos.UserLoginDTO;
import com.example.users.entities.UsersEntity;

import java.util.Optional;
import java.util.UUID;

public interface IUser {
    public void insertUser(UserCreateDTO user);
    public Optional<UsersEntity> login(UserLoginDTO user);
    public void updateUser(UserCreateDTO user);
    public Optional<UsersEntity> getUserById(UUID id);
}
