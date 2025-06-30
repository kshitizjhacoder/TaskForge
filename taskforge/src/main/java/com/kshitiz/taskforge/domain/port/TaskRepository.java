package com.kshitiz.taskforge.domain.port;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.kshitiz.taskforge.domain.model.Priority;
import com.kshitiz.taskforge.domain.model.Task;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(UUID id);
    List<Task> findAll();
    Optional<Task> findByTitle(String title);
    List<Task> getByPriority(Priority priority);
}
