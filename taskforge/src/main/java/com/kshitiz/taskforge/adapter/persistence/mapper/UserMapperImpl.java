package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.domain.model.User;
import com.kshitiz.taskforge.adapter.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(User user) {
        return new UserEntity(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole()
        );
    }

    @Override
    public User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getRole()
        );
    }
}
