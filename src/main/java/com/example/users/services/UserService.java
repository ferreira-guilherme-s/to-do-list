package com.example.users.services;

import com.example.users.dtos.UserCreateDTO;
import com.example.users.dtos.UserLoginDTO;
import com.example.users.entities.UsersEntity;
import com.example.users.interfaces.IUser;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser {
    @Override
    public void insertUser(UserCreateDTO user) {

    }

    @Override
    public UsersEntity login(UserLoginDTO user) {
        return null;
    }

    @Override
    public void updateUser(UserCreateDTO user) {

    }
}
