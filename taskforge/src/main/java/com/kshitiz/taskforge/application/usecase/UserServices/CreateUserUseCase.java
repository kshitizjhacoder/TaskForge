package com.kshitiz.taskforge.application.usecase.UserServices;
import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.UserDTO;
import com.kshitiz.taskforge.domain.model.User;
import com.kshitiz.taskforge.domain.port.UserRepository;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UserDTO   dto) {
        User user = User.create(dto.getName(), dto.getEmail(), dto.getRole());
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getRole());
    }
}
