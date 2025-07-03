package com.kshitiz.taskforge.application.usecase.UserServices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.UserDTO;
import com.kshitiz.taskforge.domain.port.UserRepository;

@Service
public class FindUserByEmailUseCase {

    private final UserRepository userRepository;

    public FindUserByEmailUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> execute(String email) {
        return userRepository.findByEmail(email)
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole()));
    }
}