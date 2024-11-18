package com.example.To_do_list.services;

import com.example.To_do_list.dtos.CreateTaskDTO;
import com.example.To_do_list.entities.ToDoEntity;
import com.example.To_do_list.interfaces.IToDoList;
import com.example.To_do_list.repositories.ToDoListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ToDoListService implements IToDoList {
    private final ModelMapper modelMapper;
    private final ToDoListRepository toDoRepository;

    @Autowired
    public ToDoListService(ToDoListRepository toDoRepository, ModelMapper modelMapper) {
        this.toDoRepository = toDoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void insertTask(CreateTaskDTO task, UUID userId) {
        try {
            task.setUserId(userId);

            ToDoEntity taskEntity = modelMapper.map(task, ToDoEntity.class);

            toDoRepository.save(taskEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteTask(UUID id) {

    }

    @Override
    public void updateTask(UUID id, String task) {

    }
}
