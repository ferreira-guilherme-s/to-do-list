package com.example.To_do_list.repositories;

import com.example.To_do_list.entities.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoEntity, UUID> {
    Optional<ToDoEntity> findByUser_Id(UUID userId);
}
