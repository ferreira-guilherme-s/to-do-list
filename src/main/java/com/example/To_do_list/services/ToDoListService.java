package com.example.To_do_list.services;

import com.example.To_do_list.dtos.CreateTaskDTO;
import com.example.To_do_list.entities.ToDoEntity;
import com.example.To_do_list.interfaces.IToDoList;
import com.example.To_do_list.repositories.ToDoListRepository;
import com.example.users.entities.UsersEntity;
import com.example.users.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoListService implements IToDoList {
    private final ModelMapper modelMapper;
    private final ToDoListRepository toDoRepository;
    private final UserService userService;

    @Autowired
    public ToDoListService(ToDoListRepository toDoRepository, ModelMapper modelMapper, UserService userService) {
        this.toDoRepository = toDoRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public void insertTask(CreateTaskDTO task, UUID userId) {
        try {
            Optional<UsersEntity> userOpt = userService.getUserById(userId);

            if (userOpt.isEmpty()) {
                return;
            }
            UsersEntity user = userOpt.get();

            ToDoEntity taskEntity = modelMapper.map(task, ToDoEntity.class);

            taskEntity.setUser(user);

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
