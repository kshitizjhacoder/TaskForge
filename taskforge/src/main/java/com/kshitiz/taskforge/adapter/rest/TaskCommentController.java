package com.kshitiz.taskforge.adapter.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kshitiz.taskforge.application.dto.TaskCommentDTO;
import com.kshitiz.taskforge.application.usecase.TaskCommentServices.CreateTaskCommentService;
import com.kshitiz.taskforge.application.usecase.TaskCommentServices.GetCommentsByTaskIdService;
import com.kshitiz.taskforge.application.usecase.TaskCommentServices.GetCommentsByUserIdService;

@RestController
@RequestMapping("/api/comments")
public class TaskCommentController {

    private final CreateTaskCommentService addTaskCommentUseCase;
    private final GetCommentsByTaskIdService getCommentsByTaskIdUseCase;
    private final GetCommentsByUserIdService getCommentsByUserIdUseCase;

    public TaskCommentController(CreateTaskCommentService addTaskCommentUseCase,
                                 GetCommentsByTaskIdService getCommentsByTaskIdUseCase,
                                 GetCommentsByUserIdService getCommentsByUserIdUseCase) {
        this.addTaskCommentUseCase = addTaskCommentUseCase;
        this.getCommentsByTaskIdUseCase = getCommentsByTaskIdUseCase;
        this.getCommentsByUserIdUseCase = getCommentsByUserIdUseCase;
    }

    @PostMapping
    public ResponseEntity<TaskCommentDTO> addComment(@RequestBody TaskCommentDTO command) {
        return ResponseEntity.ok(addTaskCommentUseCase.create(command));
    }

    @GetMapping("/task/{taskId}")
    public List<TaskCommentDTO> getCommentsByTask(@PathVariable UUID taskId) {
        return getCommentsByTaskIdUseCase.getByTaskId(taskId);
    }

    @GetMapping("/user/{userId}")
    public List<TaskCommentDTO> getCommentsByUser(@PathVariable UUID userId) {
        return getCommentsByUserIdUseCase.getByUserId(userId);
    }
}
