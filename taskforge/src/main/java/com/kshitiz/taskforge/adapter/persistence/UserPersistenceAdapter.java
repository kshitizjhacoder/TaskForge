package com.kshitiz.taskforge.adapter.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kshitiz.taskforge.adapter.persistence.entity.UserEntity;
import com.kshitiz.taskforge.adapter.persistence.mapper.UserMapper;
import com.kshitiz.taskforge.adapter.persistence.repository.JpaUserRepository;
import com.kshitiz.taskforge.domain.model.User;
import com.kshitiz.taskforge.domain.port.UserRepository;

@Component
public class UserPersistenceAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public UserPersistenceAdapter(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        return userMapper.toDomain(jpaUserRepository.save(entity));
    }

    @Override
    public List<User> findByName(String name) {
        return jpaUserRepository.findByName(name)
                .stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public List<User> findByRole(String role) {
        return jpaUserRepository.findByRole(role)
                .stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }
}
