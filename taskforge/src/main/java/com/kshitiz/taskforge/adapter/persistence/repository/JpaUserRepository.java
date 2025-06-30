package com.kshitiz.taskforge.adapter.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitiz.taskforge.adapter.persistence.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByRole(String role);
}
