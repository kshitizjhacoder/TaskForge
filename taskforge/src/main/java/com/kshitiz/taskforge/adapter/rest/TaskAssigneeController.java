package com.kshitiz.taskforge.adapter.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kshitiz.taskforge.application.dto.TaskAssigneeDTO;
import com.kshitiz.taskforge.application.usecase.TaskAssigneeServices.AssignUserToTaskService;
import com.kshitiz.taskforge.application.usecase.TaskAssigneeServices.GetAssigneesByTaskIdService;
import com.kshitiz.taskforge.application.usecase.TaskAssigneeServices.GetAssignmentsByUserIdService;

@RestController
@RequestMapping("/api/assignees")
public class TaskAssigneeController {

    private final AssignUserToTaskService assignUserToTaskUseCase;
    private final GetAssigneesByTaskIdService getAssigneesByTaskIdUseCase;
    private final GetAssignmentsByUserIdService getTasksByUserIdUseCase;

    public TaskAssigneeController(AssignUserToTaskService assignUserToTaskUseCase,
                                  GetAssigneesByTaskIdService getAssigneesByTaskIdUseCase,
                                  GetAssignmentsByUserIdService getTasksByUserIdUseCase) {
        this.assignUserToTaskUseCase = assignUserToTaskUseCase;
        this.getAssigneesByTaskIdUseCase = getAssigneesByTaskIdUseCase;
        this.getTasksByUserIdUseCase = getTasksByUserIdUseCase;
    }

    @PostMapping
    public ResponseEntity<TaskAssigneeDTO> assignUser(@RequestParam TaskAssigneeDTO taskAssigneeDTO) {
        return ResponseEntity.ok(assignUserToTaskUseCase.assign(taskAssigneeDTO));
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssigneeDTO> getAssigneesByTaskId(@PathVariable UUID taskId) {
        return getAssigneesByTaskIdUseCase.getByTaskId(taskId);
    }

    @GetMapping("/user/{userId}")
    public List<TaskAssigneeDTO> getTasksByUserId(@PathVariable UUID userId) {
        return getTasksByUserIdUseCase.getByUserId(userId);
    }
}
