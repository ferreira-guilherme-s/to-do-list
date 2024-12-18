package com.example.users.repositories;

import com.example.users.entities.UsersEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, UUID> {
    @EntityGraph(attributePaths = {"tasks"})
    Optional<UsersEntity> findByEmail(String email);
}
