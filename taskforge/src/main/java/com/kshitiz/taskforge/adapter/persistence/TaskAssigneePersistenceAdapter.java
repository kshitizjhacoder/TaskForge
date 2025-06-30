package com.kshitiz.taskforge.adapter.persistence;

import org.springframework.stereotype.Repository;

import com.kshitiz.taskforge.domain.port.TaskAssigneeRepository;
import com.kshitiz.taskforge.adapter.persistence.mapper.TaskAssigneeMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.kshitiz.taskforge.adapter.persistence.repository.JpaTaskAssigneeRepository;
import com.kshitiz.taskforge.domain.model.TaskAssignee;
@Repository
public class TaskAssigneePersistenceAdapter implements TaskAssigneeRepository{
    private final JpaTaskAssigneeRepository jpaTaskAssigneeRepository;
    private final TaskAssigneeMapper taskAssigneeMapper;
    public TaskAssigneePersistenceAdapter(JpaTaskAssigneeRepository jpaTaskAssigneeRepository, TaskAssigneeMapper taskAssigneeMapper){
        this.jpaTaskAssigneeRepository = jpaTaskAssigneeRepository;
        this.taskAssigneeMapper = taskAssigneeMapper;
    }
    @Override 
    public TaskAssignee save(UUID taskId, UUID userId){
        TaskAssignee taskAssignee = new TaskAssignee(taskId, userId);
        return taskAssigneeMapper.toDomain(jpaTaskAssigneeRepository.save(taskAssigneeMapper.toEntity(taskAssignee)));
    }
    @Override
    public List<TaskAssignee> findByTaskId(UUID taskId){
        return jpaTaskAssigneeRepository.findByTaskId(taskId).stream().map(taskAssigneeMapper::toDomain).collect(Collectors.toList());
    }
    @Override
    public List<TaskAssignee> findByUserId(UUID userId){
        return jpaTaskAssigneeRepository.findByUserId(userId).stream().map(taskAssigneeMapper::toDomain).collect(Collectors.toList());
    }
}
