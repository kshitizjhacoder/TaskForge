package com.kshitiz.taskforge.application.usecase.UserServices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.UserDTO;
import com.kshitiz.taskforge.domain.port.UserRepository;

@Service
public class FindUserByNameUseCase {

    private final UserRepository userRepository;

    public FindUserByNameUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> execute(String name) {
        return userRepository.findByName(name)
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole()))
                .collect(Collectors.toList());
    }
}