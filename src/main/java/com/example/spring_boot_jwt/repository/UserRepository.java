package com.example.spring_boot_jwt.repository;

import com.example.spring_boot_jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
