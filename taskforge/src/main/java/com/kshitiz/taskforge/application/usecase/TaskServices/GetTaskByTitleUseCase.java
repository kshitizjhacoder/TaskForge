package com.kshitiz.taskforge.application.usecase.TaskServices;
import java.util.Optional;

import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;
public class GetTaskByTitleUseCase {
    private final TaskRepository taskRepository;

    public GetTaskByTitleUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> execute(String title) {
        return taskRepository.findByTitle(title);
    }
}
