package com.example.users.interfaces;

import com.example.users.dtos.UserCreateDTO;
import com.example.users.dtos.UserLoginDTO;
import com.example.users.entities.UsersEntity;

public interface IUser {
    public void insertUser(UserCreateDTO user);
    public UsersEntity login(UserLoginDTO user);

    public void updateUser(UserCreateDTO user);
}
