package com.kshitiz.taskforge.application.usecase.TaskCommentServices;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskCommentDTO;
import com.kshitiz.taskforge.domain.model.TaskComment;
import com.kshitiz.taskforge.domain.port.TaskCommentRepository;

@Service
public class CreateTaskCommentService {

    private final TaskCommentRepository taskCommentRepository;

    public CreateTaskCommentService(TaskCommentRepository taskCommentRepository) {
        this.taskCommentRepository = taskCommentRepository;
    }

    public TaskCommentDTO create(TaskCommentDTO dto) {
        TaskComment taskComment = new TaskComment(
            UUID.randomUUID(),
            dto.taskId(),
            dto.userId(),
            dto.content(),
            null
        );
        TaskComment saved = taskCommentRepository.save(taskComment);

        return new TaskCommentDTO(
            saved.getId(),
            saved.getTaskId(),
            saved.getUserId(),
            saved.getContent(),
            saved.getCommentedOn()
        );
    }
}