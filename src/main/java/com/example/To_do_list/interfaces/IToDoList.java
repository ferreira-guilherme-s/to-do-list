package com.example.To_do_list.interfaces;

import com.example.To_do_list.dtos.CreateTaskDTO;

import java.util.UUID;

public interface IToDoList {
    public void insertTask(CreateTaskDTO task, UUID userId);
    public void deleteTask(UUID id);
    public void updateTask(UUID id, String task);
}
