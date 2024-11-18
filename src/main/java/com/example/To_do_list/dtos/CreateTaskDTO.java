package com.example.To_do_list.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CreateTaskDTO {
    @NotBlank(message = "Task is required")
    private String task;

    private UUID userId;

    public CreateTaskDTO(String task, UUID userId) {
        this.task = task;
        this.userId = userId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
