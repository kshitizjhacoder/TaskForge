package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.adapter.persistence.entity.UserEntity;
import com.kshitiz.taskforge.domain.model.User;

public interface UserMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);
}
