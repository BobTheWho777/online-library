package com.example.library.online_library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.online_library.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
