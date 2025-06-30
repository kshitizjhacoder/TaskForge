package com.kshitiz.taskforge.adapter.persistence;

import com.kshitiz.taskforge.adapter.persistence.mapper.TaskMapper;
import com.kshitiz.taskforge.adapter.persistence.repository.JpaTaskRepository;
import com.kshitiz.taskforge.domain.model.Priority;
import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskPersistenceAdapter implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;

    public TaskPersistenceAdapter(JpaTaskRepository jpaTaskRepository, TaskMapper taskMapper) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task save(Task task) {
        return taskMapper.toDomain(jpaTaskRepository.save(taskMapper.toEntity(task)));
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return jpaTaskRepository.findById(id).map(taskMapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(taskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findByTitle(String title) {
        return jpaTaskRepository.findByTitle(title).map(taskMapper::toDomain);
    }

    @Override
    public List<Task> getByPriority(Priority priority) {
        return jpaTaskRepository.findByPriority(priority).stream()
                .map(taskMapper::toDomain)
                .collect(Collectors.toList());
    }
}
