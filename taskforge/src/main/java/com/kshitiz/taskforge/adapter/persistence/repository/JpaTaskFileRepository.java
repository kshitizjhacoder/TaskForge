package com.kshitiz.taskforge.adapter.persistence.repository;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskFileEntity;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskFileId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface JpaTaskFileRepository extends JpaRepository<TaskFileEntity, TaskFileId> {
    List<TaskFileEntity> findByTaskId(UUID taskId);
}
