package com.kshitiz.taskforge.application.usecase.UserServices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.UserDTO;
import com.kshitiz.taskforge.domain.port.UserRepository;

@Service
public class FindUsersByRoleUseCase {

    private final UserRepository userRepository;

    public FindUsersByRoleUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(String role) {
        return userRepository.findByRole(role)
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole()))
                .collect(Collectors.toList());
    }
}