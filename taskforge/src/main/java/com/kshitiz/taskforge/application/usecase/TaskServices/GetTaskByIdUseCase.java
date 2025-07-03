package com.kshitiz.taskforge.application.usecase.TaskServices;
import java.util.Optional;
import java.util.UUID;

import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;
public class GetTaskByIdUseCase {
    private final TaskRepository taskRepository;

    public GetTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> execute(UUID taskId) {
        return taskRepository.findById(taskId);
    }
}
