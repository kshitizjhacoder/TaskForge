package com.kshitiz.taskforge.adapter.persistence;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskFileEntity;
import com.kshitiz.taskforge.adapter.persistence.repository.JpaTaskFileRepository;
import com.kshitiz.taskforge.domain.model.TaskFile;
import com.kshitiz.taskforge.domain.port.TaskFileRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskFilePersistenceAdapter implements TaskFileRepository {

    private final JpaTaskFileRepository jpaTaskFileRepository;

    public TaskFilePersistenceAdapter(JpaTaskFileRepository jpaTaskFileRepository) {
        this.jpaTaskFileRepository = jpaTaskFileRepository;
    }

    @Override
    public TaskFile save(UUID taskId, UUID fileId) {
        TaskFileEntity entity = new TaskFileEntity(taskId, fileId);
        TaskFileEntity saved = jpaTaskFileRepository.save(entity);
        return new TaskFile(saved.getTaskId(), saved.getFileId());
    }

    @Override
    public List<TaskFile> findByTaskId(UUID taskId) {
        return jpaTaskFileRepository.findByTaskId(taskId).stream()
                .map(entity -> new TaskFile(entity.getTaskId(), entity.getFileId()))
                .collect(Collectors.toList());
    }
}
