package com.example.To_do_list.controllers;

import com.example.To_do_list.dtos.CreateTaskDTO;
import com.example.To_do_list.services.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ToDoListController {
    private final ToDoListService toDoService;

    public ToDoListController(ToDoListService toDoService) {
        this.toDoService = toDoService;
    }
    @PostMapping("/task/{userId}")
    public ResponseEntity<Void> insertTask(@PathVariable UUID userId, @Valid @RequestBody CreateTaskDTO task) {
        try {
            toDoService.insertTask(task, userId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
