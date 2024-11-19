package com.example.To_do_list.dtos;

import com.example.To_do_list.enums.StatusTask;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CreateTaskDTO {
    @NotBlank(message = "Task is required")
    private String annotation;

    private UUID userId;

    private StatusTask status;

    public CreateTaskDTO(String annotation, UUID userId, StatusTask status) {
        this.annotation = annotation;
        this.userId = userId;
        this.status = (status != null) ? status : StatusTask.WAITING;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String task) {
        this.annotation = task;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status != null ? status : StatusTask.WAITING;
    }
}
