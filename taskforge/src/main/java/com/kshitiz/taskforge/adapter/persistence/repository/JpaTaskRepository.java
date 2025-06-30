package com.kshitiz.taskforge.adapter.persistence.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskEntity;
import com.kshitiz.taskforge.domain.model.Priority;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, UUID> {
    Optional<TaskEntity> findByTitle(String title);
    List<TaskEntity> findByPriority(Priority priority);
}
