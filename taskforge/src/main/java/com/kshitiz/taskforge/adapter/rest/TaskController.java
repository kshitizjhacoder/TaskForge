package com.kshitiz.taskforge.adapter.rest;

import com.kshitiz.taskforge.application.usecase.TaskServices.*;
import com.kshitiz.taskforge.application.dto.CreateTaskCommand;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kshitiz.taskforge.domain.model.Priority;

import java.util.UUID;
import java.util.List;  

import com.kshitiz.taskforge.domain.model.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final GetTaskByTitleUseCase getTaskByTitleUseCase;
    private final GetAllTasksUseCase getAllTasksUseCase;
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTasksByPriorityUseCase getTasksByPriorityUseCase;
    public TaskController(GetTaskByIdUseCase getTaskByIdUseCase,
                          GetTaskByTitleUseCase getTaskByTitleUseCase,
                          GetAllTasksUseCase getAllTasksUseCase,
                          CreateTaskUseCase createTaskUseCase,
                          GetTasksByPriorityUseCase getTasksByPriorityUseCase) {
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.getTaskByTitleUseCase = getTaskByTitleUseCase;
        this.getAllTasksUseCase = getAllTasksUseCase;
        this.createTaskUseCase = createTaskUseCase;
        this.getTasksByPriorityUseCase = getTasksByPriorityUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID id) {
        return getTaskByIdUseCase.execute(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Task> getTaskByTitle(@PathVariable String title) {
        return getTaskByTitleUseCase.execute(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return getAllTasksUseCase.execute();
    }
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        Priority enumPriority = Priority.valueOf(priority.toUpperCase());
        return getTasksByPriorityUseCase.execute(enumPriority);
    }


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskCommand command) {
        return ResponseEntity.ok(createTaskUseCase.createTask(command));
    }
}
