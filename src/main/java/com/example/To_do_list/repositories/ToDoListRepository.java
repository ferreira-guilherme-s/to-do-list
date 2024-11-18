package com.example.To_do_list.repositories;

import com.example.To_do_list.entities.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ToDoListRepository extends JpaRepository<ToDoEntity, UUID> {
    Optional<ToDoEntity> findByUser_Id(UUID userId);
}
