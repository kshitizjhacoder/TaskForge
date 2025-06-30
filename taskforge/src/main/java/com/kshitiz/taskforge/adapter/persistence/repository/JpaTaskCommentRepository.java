package com.kshitiz.taskforge.adapter.persistence.repository;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface JpaTaskCommentRepository extends JpaRepository<TaskCommentEntity, UUID> {
    
    List<TaskCommentEntity> findByTaskId(UUID taskId);

    List<TaskCommentEntity> findByUserId(UUID userId);
}
