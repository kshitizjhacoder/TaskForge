package com.kshitiz.taskforge.domain.port;
import java.util.List;
import java.util.Optional;  

import com.kshitiz.taskforge.domain.model.User;
public interface UserRepository {
    User save(User user);
    List<User> findByName(String name); // multiple users may share the same name
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
}
