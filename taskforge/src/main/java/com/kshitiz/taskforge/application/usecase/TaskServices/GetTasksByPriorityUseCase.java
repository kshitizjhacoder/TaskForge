package com.kshitiz.taskforge.application.usecase.TaskServices;

import java.util.List;

import com.kshitiz.taskforge.domain.model.Priority;
import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;
public class GetTasksByPriorityUseCase {
    private final TaskRepository taskRepository;

    public GetTasksByPriorityUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> execute(Priority priority) {
        return taskRepository.getByPriority(priority);
    }
}
