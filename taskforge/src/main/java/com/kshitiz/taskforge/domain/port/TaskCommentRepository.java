package com.kshitiz.taskforge.domain.port;
import com.kshitiz.taskforge.domain.model.TaskComment;
import java.util.UUID;
import java.util.List;

public interface TaskCommentRepository {
    TaskComment save(TaskComment taskComment);
    List<TaskComment> findByTaskId(UUID taskId);
    List<TaskComment> findByUserId(UUID userId);
}
