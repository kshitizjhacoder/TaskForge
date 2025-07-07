package com.kshitiz.taskforge.adapter.rest;

import com.kshitiz.taskforge.application.dto.UserDTO;
import com.kshitiz.taskforge.application.usecase.UserServices.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final FindUserByNameUseCase findUserByNameUseCase;
    private final FindUserByEmailUseCase findUserByEmailUseCase;
    private final FindUsersByRoleUseCase findUsersByRoleUseCase;
    private final CreateUserUseCase createUserUseCase;
    
    public UserController(FindUserByNameUseCase findUserByNameUseCase,
                          FindUserByEmailUseCase findUserByEmailUseCase,
                          FindUsersByRoleUseCase findUsersByRoleUseCase,
                          CreateUserUseCase createUserUseCase) {
        this.findUserByNameUseCase = findUserByNameUseCase;
        this.findUserByEmailUseCase = findUserByEmailUseCase;
        this.findUsersByRoleUseCase = findUsersByRoleUseCase;
        this.createUserUseCase = createUserUseCase;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDTO>> getUserByName(@PathVariable String name) {
        List<UserDTO> users = findUserByNameUseCase.execute(name);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<UserDTO> user = findUserByEmailUseCase.execute(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDTO>> getUsersByRole(@PathVariable String role) {
        List<UserDTO> users = findUsersByRoleUseCase.execute(role);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = createUserUseCase.execute(userDTO);
        return ResponseEntity.status(201).body(createdUser);
    }
}
