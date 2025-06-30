package com.kshitiz.taskforge.adapter.persistence.repository;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskAssigneeEntity;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskAssigneeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaTaskAssigneeRepository extends JpaRepository<TaskAssigneeEntity, TaskAssigneeId> {
    List<TaskAssigneeEntity> findByTaskId(UUID taskId);
    List<TaskAssigneeEntity> findByUserId(UUID userId);
}
