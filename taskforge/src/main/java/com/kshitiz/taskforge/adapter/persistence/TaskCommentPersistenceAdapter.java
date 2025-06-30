package com.kshitiz.taskforge.adapter.persistence;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskCommentEntity;
import com.kshitiz.taskforge.adapter.persistence.mapper.TaskCommentMapper;
import com.kshitiz.taskforge.adapter.persistence.repository.JpaTaskCommentRepository;
import com.kshitiz.taskforge.domain.model.TaskComment;
import com.kshitiz.taskforge.domain.port.TaskCommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskCommentPersistenceAdapter implements TaskCommentRepository {

    private final JpaTaskCommentRepository jpaTaskCommentRepository;
    private final TaskCommentMapper mapper;

    public TaskCommentPersistenceAdapter(JpaTaskCommentRepository jpaTaskCommentRepository, TaskCommentMapper mapper) {
        this.jpaTaskCommentRepository = jpaTaskCommentRepository;
        this.mapper = mapper;
    }

    @Override
    public TaskComment save(TaskComment taskComment) {
        TaskCommentEntity entity = mapper.toEntity(taskComment);
        return mapper.toDomain(jpaTaskCommentRepository.save(entity));
    }

    @Override
    public List<TaskComment> findByUserId(UUID userId) {
        return jpaTaskCommentRepository.findByUserId(userId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskComment> findByTaskId(UUID taskId) {
        return jpaTaskCommentRepository.findByTaskId(taskId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
